package com.blog.medium.domain.member.api;

import com.blog.medium.domain.member.application.MemberService;
import com.blog.medium.domain.member.dto.SignupRequest;
import com.blog.medium.domain.member.dto.SignupResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<SignupResponse> signup(
            @RequestBody @Valid SignupRequest signupRequest
    ) {
        SignupResponse signupResponse = memberService.signup(signupRequest);

        URI uri = URI.create("/api/v1/members/" + signupResponse.getId());

        return ResponseEntity.created(uri).body(signupResponse);
    }
}
