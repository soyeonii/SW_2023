package com.sku.ui.controller;

import com.google.gson.JsonObject;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final RestTemplate restTemplate;

    @GetMapping("/showAll")
    public String showAll(Model model) {
        String result = restTemplate.getForObject("http://board/selectAll", String.class);
        System.out.println("result = " + result);

        model.addAttribute("result", result);

        return "board/showAll";
    }

    @GetMapping("/showOne/{id}")
    public String showOne(@PathVariable int id, Model model) {
        String result = restTemplate.getForObject("http://board/selectOne/{id}", String.class, id);
        System.out.println("result = " + result);

        model.addAttribute("result", result);

        return "board/showOne";
    }

    @GetMapping("/write")
    public String write() {
        return "board/write";
    }

    @PostMapping("/write")
    public String write(HttpSession session, String title, String content) {
        System.out.println("ui.boardController.write()");

        if (session.getAttribute("loginId") == null) {
            return "redirect:/";
        }

        JsonObject object = new JsonObject();
        object.addProperty("title", title);
        object.addProperty("content", content);
        object.addProperty("writerId", session.getAttribute("loginId").toString());

        System.out.println("session.getAttribute(\"loginId\") = " + session.getAttribute("loginId"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(object.toString(), headers);

        String result = restTemplate.postForObject("http://board/write", request, String.class);

        return "redirect:/board/showAll";
    }
}
