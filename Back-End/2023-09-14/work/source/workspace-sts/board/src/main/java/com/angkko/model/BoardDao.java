package com.angkko.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardDao {
	public List<NoticeboardDto> selectAllArticles() throws DataAccessException;
	public void insertArticle(NoticeboardDto noticeboardDto) throws DataAccessException;
	public NoticeboardDto selectArticle(int articleNo) throws DataAccessException;
	public void updateArticle(NoticeboardDto article) throws DataAccessException;
	public void deleteArticle(int articleNo) throws DataAccessException;
}
