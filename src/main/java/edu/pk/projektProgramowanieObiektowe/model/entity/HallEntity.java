package edu.pk.projektProgramowanieObiektowe.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hall")
public class HallEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "hallEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SeanceEntity> seanceEntity = new HashSet<>();

    @OneToMany(mappedBy = "hallEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SeatEntity> seatEntity = new HashSet<>();
}
