package com.sku.user.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sku.user.model.UserDTO;
import com.sku.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService USER_SERVICE;
    private final RestTemplate restTemplate;

    @PostMapping("/auth")
    public String auth(HttpSession session, @RequestBody UserDTO attempt) {
        System.out.println("attempt = " + attempt);
        UserDTO result = USER_SERVICE.auth(attempt);
        System.out.println("result = " + result);
        if (result != null) {
            Gson gson = new Gson();
            session.setAttribute("login", result);
            return gson.toJson(result);
        } else {
            JsonObject object = new JsonObject();
            object.addProperty("result", "fail");
            return object.toString();
        }
    }

    @GetMapping("/current")
    public int getCurrent(HttpSession session) {
        if (session.getAttribute("login") != null) {
            return ((UserDTO) session.getAttribute("login")).getId();
        }
        return -1;
    }
}