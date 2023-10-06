package com.angkko.movie.model.dto.request;

import lombok.Getter;

@Getter
public class UserSignInRequest {
    private String username;
    private String password;
}
