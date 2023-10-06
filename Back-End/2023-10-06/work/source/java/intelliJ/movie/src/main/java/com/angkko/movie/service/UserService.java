package com.angkko.movie.service;

import com.angkko.movie.model.domain.User;
import com.angkko.movie.model.dto.UserDTO;
import com.angkko.movie.model.dto.request.UserSignInRequest;
import com.angkko.movie.model.dto.request.UserSignUpRequest;
import com.angkko.movie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void addUser(UserSignUpRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .build();
        userRepository.save(user);
    }

    public UserDTO findUser(UserSignInRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
