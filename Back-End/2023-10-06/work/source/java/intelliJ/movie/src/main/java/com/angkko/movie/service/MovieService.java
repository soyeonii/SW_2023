package com.angkko.movie.service;

import com.angkko.movie.model.domain.Movie;
import com.angkko.movie.model.domain.Review;
import com.angkko.movie.model.dto.request.MovieRequest;
import com.angkko.movie.model.dto.response.MovieRatingResponse;
import com.angkko.movie.model.dto.response.MovieResponse;
import com.angkko.movie.model.dto.response.MoviesResponse;
import com.angkko.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public MoviesResponse getMovies() {
        return MoviesResponse.builder()
                .movies(movieRepository.findAllBy())
                .build();
    }

    public MovieResponse getMovie(Long movieId) {
        return MovieResponse.builder()
                .movie(movieRepository.findByIdAnd(movieId))
                .build();
    }

    public MovieRatingResponse getMovieRating(Long movieId, String userRank) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        assert movie != null;
        if (userRank == null) {
            List<Review> reviews = movie.getReviews();
            List<Double> ratings = reviews.stream()
                    .map(Review::getRating)
                    .toList();
            return MovieRatingResponse.builder()
                    .rating(calculateAverageRating(ratings))
                    .build();
        } else {
            return MovieRatingResponse.builder()
                    .rating(movieRepository.getRatingByIdAndUserRank(movieId, userRank))
                    .build();
        }

    }

    private static double calculateAverageRating(List<Double> reviewRatings) {
        if (reviewRatings.isEmpty()) {
            return 0.0;
        }
        double sum = reviewRatings.stream().mapToDouble(Double::doubleValue).sum();
        return Double.parseDouble(String.format("%.1f", sum / reviewRatings.size()));
    }

    @Transactional
    public void addMovie(MovieRequest request) {
        Movie movie = Movie.builder()
                .title(request.getTitle())
                .plot(request.getPlot())
                .rank(request.getRank())
                .build();
        movieRepository.save(movie);
    }

    @Transactional
    public void updateMovie(Long movieId, MovieRequest request) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        assert movie != null;
        if (request.getTitle() != null) {
            movie.setTitle(request.getTitle());
        }
        if (request.getPlot() != null) {
            movie.setPlot(request.getPlot());
        }
        if (request.getRank() != 0) {
            movie.setRank(request.getRank());
        }
    }

    @Transactional
    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }
}
