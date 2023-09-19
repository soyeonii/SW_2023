package com.angkko.controller;

import com.angkko.model.dto.SignInResultDto;
import com.angkko.model.dto.SignUpResultDto;
import com.angkko.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/sign-api")
@RequiredArgsConstructor
public class SignController {
    private final SignService signService;

    @PostMapping("/sign-in")
    public SignInResultDto signIn(@RequestParam("id") String id, @RequestParam("password") String password) throws RuntimeException {
        SignInResultDto signInResultDto = signService.signIn(id, password);
        if (signInResultDto.getCode() == 0) {
            System.out.println("정상 로그인 id: " + id + ", token: " + signInResultDto.getToken());
        }
        return signInResultDto;
    }

    @PostMapping("/sign-up")
    public SignUpResultDto signUp(@RequestParam("id") String id, @RequestParam("password") String password, @RequestParam("name") String name, @RequestParam("auth") String role) {
        return signService.signUp(id, password, name, role);
    }

    @GetMapping("/exception")
    public void exceptionTest() throws RuntimeException {
        throw new RuntimeException("접근 거부");
    }

    @ExceptionHandler(RuntimeException.class)
    public Map<String, String> ExceptionHandler(RuntimeException e) {
        Map<String, String> map = new HashMap<>();
        map.put("error type", BAD_REQUEST.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");
        return map;
    }
}
