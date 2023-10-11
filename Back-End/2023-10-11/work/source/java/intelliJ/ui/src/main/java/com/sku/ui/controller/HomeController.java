package com.sku.ui.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final RestTemplate restTemplate;

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @PostMapping("/auth")
    public String sendAuthRequest(HttpSession session, String username, String password){
        JsonObject object = new JsonObject();
        object.addProperty("username", username);
        object.addProperty("password", password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(object.toString(), headers);

        String result = restTemplate.postForObject("http://user/auth", request, String.class);
        System.out.println("result = " + result);

        JsonElement jsonElement = JsonParser.parseString(result);
        JsonObject resultObject = jsonElement.getAsJsonObject();
        System.out.println("resultObject.has(\"result\") = " + resultObject.has("result"));

        if (resultObject.has("result")) {
            return "redirect:/";
        } else {
            session.setAttribute("loginId", resultObject.get("id"));
            return "redirect:/board/showAll";
        }
    }
}
