package com.angkko.movie.model.dto.response;

import com.angkko.movie.model.dto.MovieDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {
    private MovieDTO movie;
}
