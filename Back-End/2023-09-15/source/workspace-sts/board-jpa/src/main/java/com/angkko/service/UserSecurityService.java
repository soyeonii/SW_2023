package com.angkko.service;

import com.angkko.model.UserRole;
import com.angkko.model.entity.BoardUser;
import com.angkko.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BoardUser boardUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
        List<GrantedAuthority> authorityList = new ArrayList<>();
        if ("admin".equals(username)) {
            authorityList.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else {
            authorityList.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }
        return new User(boardUser.getUsername(), boardUser.getPassword(), authorityList);
    }
}
