package edu.pk.projektProgramowanieObiektowe.model.DTO;

import java.time.LocalDate;
import java.util.UUID;

public record TicketDTO(
        String userEmail,
        UUID ticketId,
        LocalDate bookingDate,
        Integer discountInPercentage,
        String discountType,
        SeanceDTO seanceDTO,
        SeatDTO seatDTO
) {
}
