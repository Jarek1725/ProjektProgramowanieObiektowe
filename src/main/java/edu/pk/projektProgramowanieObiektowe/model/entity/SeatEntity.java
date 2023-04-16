package edu.pk.projektProgramowanieObiektowe.model.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "seat")
@Getter
public class SeatEntity{
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_row")
    private Integer seatRow;

    @Column(name = "seat_column")
    private Integer seatColumn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall_id")
    private HallEntity hallEntity;

    @OneToMany(mappedBy = "seatEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TicketEntity> ticketEntity = new HashSet<>();
}
