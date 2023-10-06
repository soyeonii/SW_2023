package com.angkko.movie.model.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue()
    @Column(name = "movie_id")
    private Long id;

    private String title;

    private String plot;

    private int rank;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<Screening> screenings = new ArrayList<>();
}
