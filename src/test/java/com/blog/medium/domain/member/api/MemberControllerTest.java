package com.blog.medium.domain.member.api;

import com.blog.medium.domain.member.dto.SignupRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void 회원가입_처리() throws Exception {
        // given
        SignupRequest signupRequest = SignupRequest.builder()
                .email("ddagae0805@gmail.com")
                .password("qwer1234!")
                .passwordConfirm("qwer1234!")
                .nickname("ddagae")
                .build();

        String content = objectMapper.writeValueAsString(signupRequest);

        // when
        mvc.perform(post("/api/v1/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
                        .characterEncoding("UTF-8"))
                // then
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(result -> {
                    String responseContent = result.getResponse().getContentAsString();
                    SignupRequest response = objectMapper.readValue(responseContent, SignupRequest.class);

                    assertThat(response.getEmail()).isEqualTo(signupRequest.getEmail());
                    assertThat(response.getNickname()).isEqualTo(signupRequest.getNickname());
                });
    }
}