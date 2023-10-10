package com.sku.ui.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final RestTemplate restTemplate;

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @PostMapping("/auth")
    public String sendAuthRequest(String username, String password) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("username", username);
        paramMap.put("password", password);
        restTemplate.exchange("http://user/auth", HttpMethod.POST, null, String.class, paramMap);
        return "index";
    }
}
