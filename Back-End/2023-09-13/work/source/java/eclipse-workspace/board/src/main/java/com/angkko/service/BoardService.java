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
	
	public void addArticle(NoticeboardDto article) {
		// DB에 저장하는 DAO 메서드 호출
		boardDao.insertArticle(article);
	}
	
	public NoticeboardDto viewArticle(int articleNo) {
		NoticeboardDto article = boardDao.selectArticle(articleNo);
		return article;
	}
	
	public void editArticle(NoticeboardDto article) {
		boardDao.updateArticle(article);
	}
	
	public void removeArticle(int articleNo) {
		boardDao.deleteArticle(articleNo);
	}
}
