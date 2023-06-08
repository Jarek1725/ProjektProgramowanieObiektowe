package edu.pk.projektProgramowanieObiektowe.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "movie")
public class MovieEntity{
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "description")
    private String description;

    @Column(name = "genre")
    private String genre;

    @Column(name = "director")
    private String director;

    @Column(name = "actors")
    private String actors;

    @OneToMany(mappedBy = "movieEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SeanceEntity> seanceEntity = new HashSet<>();
}
