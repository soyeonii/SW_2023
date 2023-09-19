package com.angkko.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RequestUtil {
    public static String restRequest(String requestUrl, String name) {

        // 보낼 parameter 세팅(file name)
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id", name);

        // header 세팅
        HttpHeaders headers = new HttpHeaders();
        headers.add("accept", "text/plain;charset=UTF-8");

        // parameter + header
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);
        // RestTemplate 초기화
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(
                requestUrl, HttpMethod.POST, entity, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root;
        JsonNode target = null;

        try {
            root = mapper.readTree(response.getBody());
            target = root.path("result");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return target.asText();
    }
}
