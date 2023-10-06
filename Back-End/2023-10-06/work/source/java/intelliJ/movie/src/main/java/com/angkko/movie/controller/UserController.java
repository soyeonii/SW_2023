package com.angkko.movie.controller;

import com.angkko.movie.exception.Code;
import com.angkko.movie.exception.dto.Response;
import com.angkko.movie.model.dto.UserDTO;
import com.angkko.movie.model.dto.request.UserSignInRequest;
import com.angkko.movie.model.dto.request.UserSignUpRequest;
import com.angkko.movie.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signUp")
    public Response signUp(@RequestBody UserSignUpRequest request) {
        userService.addUser(request);
        return Response.of(true, Code.OK);
    }

    @PostMapping("/signIn")
    public Response signIn(@RequestBody UserSignInRequest request, HttpSession session) {
        UserDTO userDTO = userService.findUser(request);
        session.setAttribute("user", userDTO);
        return Response.of(true, Code.OK);
    }
}
