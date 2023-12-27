package com.blog.medium.domain.member.application;

import com.blog.medium.domain.member.dao.MemberRepository;
import com.blog.medium.domain.member.dto.SignupRequest;
import com.blog.medium.domain.member.dto.SignupResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional(readOnly = true)
class MemberServiceTest {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void beforeEach() {
        memberRepository.deleteAll();
    }

    @Test
    @Transactional
    void 회원가입_정상동작() {
        // given
        SignupRequest signupRequest = SignupRequest.builder()
                .email("ddagae0805@gmail.com")
                .password("qwer1234!")
                .passwordConfirm("qwer1234!")
                .nickname("dongchul choi")
                .build();
        // when
        SignupResponse signupResponse = this.memberService.signup(signupRequest);
        // then
        assertThat(signupResponse.getEmail()).isEqualTo(signupRequest.getEmail());
        assertThat(signupResponse.getNickname()).isEqualTo(signupRequest.getNickname());
    }

    @Test
    @Transactional
    void 회원가입_중복_예외() {
        // given
        SignupRequest signupRequest = SignupRequest.builder()
                .email("ddagae0805@gmail.com")
                .password("qwer1234!")
                .passwordConfirm("qwer1234!")
                .nickname("dongchul choi")
                .build();
        // when
        this.memberService.signup(signupRequest);
        // then
        assertThrows(IllegalArgumentException.class, () -> {
            this.memberService.signup(signupRequest);
        });
    }
}