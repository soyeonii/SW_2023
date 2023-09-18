package com.angkko.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignInResultDto extends SignUpResultDto {
    private String token;

    @Builder
    public SignInResultDto(boolean success, int code, String message, String token) {
        super(success, code, message);
        this.token = token;
    }
}
