package edu.pk.projektProgramowanieObiektowe.model.DTO;

import java.time.LocalDate;
import java.util.UUID;

public record TicketDTO(
        String userEmail,
        Long ticketId,
        LocalDate bookingDate,
        String movieTitle
) {
}
