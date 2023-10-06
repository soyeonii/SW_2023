package com.angkko.movie.model.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Theater {
    @Id
    @GeneratedValue()
    @Column(name = "theater_id")
    private Long id;

    private String name;

    private String location;

    private String phoneNumber;

    @OneToMany(mappedBy = "theater")
    private List<Screening> screenings = new ArrayList<>();
}
