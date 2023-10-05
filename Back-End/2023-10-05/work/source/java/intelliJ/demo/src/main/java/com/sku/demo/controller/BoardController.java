package com.sku.demo.controller;

import com.sku.demo.model.BoardDTO;
import com.sku.demo.model.UserDTO;
import com.sku.demo.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String showHome() {
        return "index";
    }

    @GetMapping("/board/showAll")
    public ModelAndView printAll() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", boardService.selectAll());
        mv.setViewName("/board/showAll");
        return mv;
    }

    @GetMapping("/board/write")
    public String showWrite() {
        return "board/write";
    }

    @GetMapping("/board/showOne/{id}")
    public String showOne(@PathVariable int id, HttpSession session, Model model) {
        BoardDTO boardDTO = boardService.selectOne(id);
        model.addAttribute("board", boardDTO);
        model.addAttribute("logIn", (UserDTO) session.getAttribute("logIn"));
        return "board/showOne";
    }

    @PostMapping("/board/write")
    public String write(HttpSession session, BoardDTO boardDTO) {
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if (logIn != null) {
            boardDTO.setWriterId(logIn.getId());
            boardService.insert(boardDTO);
        }
        return "redirect:/board/showAll";
    }
}
