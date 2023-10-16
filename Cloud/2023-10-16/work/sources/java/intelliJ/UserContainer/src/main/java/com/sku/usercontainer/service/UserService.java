package com.sku.usercontainer.service;

import com.sku.usercontainer.model.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private SqlSession sqlSession;
    private  final  String NAMESPACE = "com.sku.mapper.UserMapper";

    public UserDTO auth(UserDTO attempt){
        return  sqlSession.selectOne(NAMESPACE + ".auth", attempt);
    }

    public void register(UserDTO attempt){
        sqlSession.insert(NAMESPACE + ".register", attempt);
    }

    public Boolean validateUsername(String username){
        return  sqlSession.selectOne(NAMESPACE + ".validateUsername", username) == null;
    }
}
