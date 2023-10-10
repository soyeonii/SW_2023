package com.sku.user.controller;

import com.sku.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService USER_SERVICE;
    private final RestTemplate restTemplate;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping ("/auth")
    public String auth(Map<String, String> paramMap) {
        System.out.println(paramMap);
//        UserDTO result = USER_SERVICE.auth(userDTO);
//        if (result != null) {
//            Gson gson = new Gson();
//            return gson.toJson(result);
//        } else {
//            JsonObject object = new JsonObject();
//            object.addProperty("result", "fail");
//            return object.toString();
//        }
        System.out.println(restTemplate.exchange("http://board/test", HttpMethod.GET, null, String.class));
        return "test";
    }
}
