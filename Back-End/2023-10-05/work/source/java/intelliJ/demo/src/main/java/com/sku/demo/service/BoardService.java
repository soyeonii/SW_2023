package com.sku.demo.service;

import com.sku.demo.model.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private SqlSession sqlSession;
    private final String NAMESPACE = "com.sku.mapper.BoardMapper";

    @Autowired
    public BoardService(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<BoardDTO> selectAll() {
        return sqlSession.selectList(NAMESPACE + ".selectAll");
    }

    public BoardDTO selectOne(int articleNo) {
        return sqlSession.selectOne(NAMESPACE + ".selectOne", articleNo);
    }

    public void insert(BoardDTO boardDTO) {
        sqlSession.insert(NAMESPACE + ".insert", boardDTO);
    }

    public void update(BoardDTO boardDTO) {
        sqlSession.update(NAMESPACE + ".update", boardDTO);
    }

    public void delete(int articleNo) {
        sqlSession.delete(NAMESPACE + ".delete", articleNo);
    }

}