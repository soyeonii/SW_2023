package com.sku.user.service;

import com.sku.user.model.UserDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping
@RequiredArgsConstructor
public class UserService {
    private final SqlSession SESSION;
    private final String NAMESPACE = "com.sku.mapper.UserMapper";

    public UserDTO auth(UserDTO attempt){
        return SESSION.selectOne("auth", attempt);
    }
}
