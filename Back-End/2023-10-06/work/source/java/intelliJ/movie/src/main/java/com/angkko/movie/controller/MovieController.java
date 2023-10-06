package com.angkko.movie.controller;

import com.angkko.movie.exception.Code;
import com.angkko.movie.exception.dto.DataResponse;
import com.angkko.movie.exception.dto.Response;
import com.angkko.movie.model.dto.request.MovieRequest;
import com.angkko.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public DataResponse getMovies() {
        return DataResponse.of(movieService.getMovies());
    }

    @GetMapping("/{movie_id}")
    public DataResponse getMovie(@PathVariable("movie_id") Long movieId) {
        return DataResponse.of(movieService.getMovie(movieId));
    }

    @GetMapping("/{movie_id}/rating")
    public DataResponse getMovieRating(@PathVariable("movie_id") Long movieId, @RequestParam("rank") String userRank) {
        return DataResponse.of(movieService.getMovieRating(movieId, userRank));
    }

    @PostMapping
    public Response addMovie(@RequestBody MovieRequest request) {
        movieService.addMovie(request);
        return Response.of(true, Code.OK);
    }

    @PatchMapping("/{movie_id}")
    public Response updateMovie(@PathVariable("movie_id") Long movieId, @RequestBody MovieRequest request) {
        movieService.updateMovie(movieId, request);
        return Response.of(true, Code.OK);
    }

    @DeleteMapping("/{movie_id}")
    public Response deleteMovie(@PathVariable("movie_id") Long movieId) {
        movieService.deleteMovie(movieId);
        return Response.of(true, Code.OK);
    }
}
