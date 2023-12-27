package com.blog.medium.domain.member.application;

import com.blog.medium.domain.member.dao.MemberRepository;
import com.blog.medium.domain.member.dto.SignupRequest;
import com.blog.medium.domain.member.dto.SignupResponse;
import com.blog.medium.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Transactional
    public SignupResponse signup(SignupRequest signupRequest) {
        this.getByEmail(signupRequest.getEmail()).ifPresent(member -> {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        });

        signupRequest.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        Member member = memberRepository.save(SignupRequest.toEntity(signupRequest));

        return SignupResponse.of(member);
    }

    public Optional<Member> getByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}
