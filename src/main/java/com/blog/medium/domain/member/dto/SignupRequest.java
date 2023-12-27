package com.blog.medium.domain.member.dto;

import com.blog.medium.domain.member.entity.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class SignupRequest {
    private Long id;
    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;
    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password;
    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String passwordConfirm;
    private String nickname;

    public void setPassword(String password) {
        this.password = password;
    }

    public static Member toEntity(SignupRequest signupRequest) {
        return Member.builder()
                .email(signupRequest.getEmail())
                .password(signupRequest.getPassword())
                .nickname(signupRequest.getNickname())
                .build();
    }
}
