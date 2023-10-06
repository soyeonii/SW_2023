package com.angkko.movie.model.dto.response;

import com.angkko.movie.model.dto.MovieDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MoviesResponse {
    private List<MovieDTO> movies;
}
