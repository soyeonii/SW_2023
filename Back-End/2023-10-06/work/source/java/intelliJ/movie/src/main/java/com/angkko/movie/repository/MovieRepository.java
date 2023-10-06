package com.angkko.movie.repository;

import com.angkko.movie.model.domain.Movie;
import com.angkko.movie.model.dto.MovieDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<MovieDTO> findAllBy();

    MovieDTO findByIdAnd(Long movieId);

    @Query("SELECT SUM(r.rating) / COUNT(*)" +
            "FROM Review r " +
            "JOIN User u ON r.user.id = u.id " +
            "WHERE r.movie.id = :movieId " +
            "AND u.rank = :rank")
    double getRatingByIdAndUserRank(@Param("movieId") Long movieId, @Param("rank") String rank);
}
