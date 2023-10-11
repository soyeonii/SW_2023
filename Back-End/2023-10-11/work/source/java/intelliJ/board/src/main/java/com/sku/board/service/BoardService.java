package com.sku.board.service;

import com.sku.board.model.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final SqlSession sqlSession;
    private final String NAMESPACE = "com.sku.mapper.BoardMapper";

    public List<BoardDTO> selectAll() {
        return sqlSession.selectList(NAMESPACE + ".selectAll");
    }

    public BoardDTO selectOne(int id) {
        return sqlSession.selectOne(NAMESPACE + ".selectOne", id);
    }

    public void insert(BoardDTO boardDTO) {
        sqlSession.insert(NAMESPACE + ".insert", boardDTO);
    }
}
