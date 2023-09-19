package com.angkko.repository;

import com.angkko.model.entity.Ramen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RamenRespository extends JpaRepository<Ramen, Integer> {
}
