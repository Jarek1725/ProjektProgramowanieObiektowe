package edu.pk.projektProgramowanieObiektowe.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hall")
@Getter
@Setter
public class HallEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "row_seats")
    private Long rowSeats;

    @Column(name = "column_seats")
    private Long columnSeats;

    @OneToMany(mappedBy = "hallEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<SeanceEntity> seanceEntity = new HashSet<>();

}
