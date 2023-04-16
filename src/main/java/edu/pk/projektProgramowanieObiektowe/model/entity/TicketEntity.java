package edu.pk.projektProgramowanieObiektowe.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "ticket")
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class TicketEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "dicount_in_percentage")
    private Integer discountInPercentage;

    @Column(name = "discount_type")
    private String discountType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seance_id")
    private SeanceEntity seanceEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seat_id")
    private SeatEntity seatEntity;
}
