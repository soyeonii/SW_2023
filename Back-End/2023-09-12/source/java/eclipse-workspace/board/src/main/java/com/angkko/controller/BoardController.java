package com.angkko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.angkko.model.NoticeboardDto;
import com.angkko.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private NoticeboardDto noticeboardDto;

	@RequestMapping({ "/list", "/" })
	public String getArticleList(Model model) {
		List<NoticeboardDto> articleList = boardService.listArticles();
		model.addAttribute("dataList", articleList);
		return "list";
	}
}
