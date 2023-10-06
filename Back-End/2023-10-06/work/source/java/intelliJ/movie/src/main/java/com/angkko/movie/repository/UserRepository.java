package com.angkko.movie.repository;

import com.angkko.movie.model.domain.User;
import com.angkko.movie.model.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    UserDTO findByUsernameAndPassword(String username, String password);
}
