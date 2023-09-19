package com.angkko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.angkko.controller.BoardController;
import com.angkko.controller.RestSvcController;
import com.angkko.model.BoardDao;
import com.angkko.model.NoticeboardDto;
import com.angkko.service.BoardService;

@Configuration
public class BoardConfig {
	@Bean
	public NoticeboardDto noticeboardDto() {
		return new NoticeboardDto();
	}
	
	@Bean
	public BoardDao boardDao() {
		return new BoardDao();
	}
	
	@Bean
	public BoardService boardService() {
		return new BoardService();
	}
	
	@Bean
	public BoardController boardController() {
		return new BoardController(); 
	}
	
	@Bean
	public RestSvcController restSvcController() {
		return new RestSvcController(); 
	}
}
