package com.angkko.repository;

import com.angkko.model.entity.BoardUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<BoardUser, Long> {
    Optional<BoardUser> findByUsername(String username);
}
