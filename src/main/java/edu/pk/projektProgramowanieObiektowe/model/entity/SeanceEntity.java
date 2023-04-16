package edu.pk.projektProgramowanieObiektowe.model.entity;


import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "seance")
@Getter
public class SeanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_time")
    private LocalDate startTime;

    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hall_id")
    private HallEntity hallEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id")
    private MovieEntity movieEntity;

    @OneToMany(mappedBy = "seanceEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TicketEntity> ticketEntity = new HashSet<>();
}
