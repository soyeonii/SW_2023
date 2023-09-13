package com.angkko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.angkko.model.BoardDao;
import com.angkko.model.NoticeboardDto;

public class BoardService {
	@Autowired
	private BoardDao boardDao;

	public List<NoticeboardDto> listArticles() {
		List<NoticeboardDto> articleList = boardDao.selectAllArticles();
		return articleList;
	}
}
