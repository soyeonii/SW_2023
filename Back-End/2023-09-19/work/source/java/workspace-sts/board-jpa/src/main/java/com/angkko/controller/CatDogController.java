package com.angkko.controller;

import com.angkko.service.FileTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class CatDogController {
    private final FileTransferService fileTransferService;

    Map<String, String> map = new HashMap<>();

    @PostMapping("/upload")
    public Map<String, String> uploadImage(@RequestPart(value = "uploadfile") MultipartFile uploadfile) throws IllegalStateException, IOException {
        String catordog = fileTransferService.webToLocal(uploadfile);
        map.put("catordog", catordog);
        System.out.println(map);

        return map;
    }
}
