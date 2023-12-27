package com.blog.medium;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestUtil {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
