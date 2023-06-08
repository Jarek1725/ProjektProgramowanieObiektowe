package edu.pk.projektProgramowanieObiektowe.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "ticket")
@Builder
@Setter
@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "column_seat")
    private Long columnSeat;

    @Column(name = "row_seat")
    private Long rowSeat;

    @Column(name = "booking_date")
    @CreationTimestamp
    private LocalDate bookingDate = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seance_id")
    private SeanceEntity seanceEntity;
}
