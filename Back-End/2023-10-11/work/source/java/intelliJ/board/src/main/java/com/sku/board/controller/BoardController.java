package com.sku.board.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.sku.board.model.BoardDTO;
import com.sku.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final RestTemplate restTemplate;
    private final BoardService boardService;

    @GetMapping("/selectAll")
    public String selectAll() {
        List<BoardDTO> list = boardService.selectAll();
        Gson gson = new Gson();
        JsonArray resultArray = new JsonArray();
        for (BoardDTO board : list) {
            resultArray.add(gson.toJson(board));
        }
        return resultArray.toString();
    }

    @GetMapping("/selectOne/{id}")
    public String selectOne(@PathVariable int id) {
        BoardDTO boardDTO = boardService.selectOne(id);
        Gson gson = new Gson();
        return gson.toJson(boardDTO);
    }

    @PostMapping("/write")
    public String write(@RequestBody BoardDTO boardDTO) {
        System.out.println("board.boardController.write()");
        System.out.println("boardDTO = " + boardDTO);

        Integer id = restTemplate.getForObject("http://user/current", Integer.class);
        System.out.println("id = " + id);

        System.out.println("before insert boardDTO = " + boardDTO);
        boardService.insert(boardDTO);
        System.out.println("after insert boardDTO = " + boardDTO);

        return "board.write()";
    }
}
