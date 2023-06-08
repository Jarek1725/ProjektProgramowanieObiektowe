package edu.pk.projektProgramowanieObiektowe.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "seance")
@Getter
@Setter
public class SeanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id")
    private Long id;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hall_id", referencedColumnName = "id")
    private HallEntity hallEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private MovieEntity movieEntity;

    @JsonIgnore
    @OneToMany(mappedBy = "seanceEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TicketEntity> ticketEntity = new HashSet<>();


}
