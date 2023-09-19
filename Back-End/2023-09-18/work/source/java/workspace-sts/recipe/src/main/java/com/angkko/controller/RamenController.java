package com.angkko.controller;

import com.angkko.model.entity.Ramen;
import com.angkko.service.RamenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ramen")
@RequiredArgsConstructor
public class RamenController {
    private final RamenService ramenService;

    @GetMapping("/get/{num}")
    public Ramen getRecipe(@PathVariable("num") int no) throws Exception {
        return ramenService.getContent(no);
    }
}
