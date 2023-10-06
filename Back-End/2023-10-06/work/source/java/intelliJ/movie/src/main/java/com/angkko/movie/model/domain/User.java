package com.angkko.movie.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue()
    @Column(name = "user_id")
    private Long id;

    private String username;

    private String password;

    private String nickname;

    @Convert(converter = RankAttributeConverter.class)
    @ColumnDefault("1")
    private String rank;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();
}
