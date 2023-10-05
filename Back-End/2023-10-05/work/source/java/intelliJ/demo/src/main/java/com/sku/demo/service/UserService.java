package com.sku.demo.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sku.demo.model.UserDTO;

@Service
public class UserService {
    private SqlSession sqlSession;
    private final String NAMESPACE = "com.sku.mapper.UserMapper";

    @Autowired
    public UserService(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public UserDTO auth(UserDTO userDTO) {
        return sqlSession.selectOne(NAMESPACE + ".auth", userDTO);
    }

    public void register(UserDTO userDTO) {
        sqlSession.insert(NAMESPACE + ".register", userDTO);
    }
}