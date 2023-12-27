package com.blog.medium.domain.member.dto;

import com.blog.medium.domain.member.entity.Member;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class SignupResponse {
    private Long id;
    private String email;
    private String nickname;

    public static SignupResponse of(Member member) {
        return SignupResponse.builder()
                .id(member.getId())
                .email(member.getEmail())
                .nickname(member.getNickname())
                .build();
    }
}
