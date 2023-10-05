package com.sku.demo.controller;

import com.sku.demo.model.UserDTO;
import com.sku.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user/")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("register")
    public String showRegister() {
        return "user/register";
    }

    @PostMapping("register")
    public String register(UserDTO userDTO) {
        userService.register(userDTO);
        return "redirect:/";
    }

    @PostMapping("auth")
    public String auth(HttpSession session, UserDTO userDTO) {
        UserDTO logIn = userService.auth(userDTO);
        if (logIn != null) {
            session.setAttribute("logIn", logIn);
            return "redirect:/board/showAll";
        } else {
            return "redirect:/";
        }
    }
}
