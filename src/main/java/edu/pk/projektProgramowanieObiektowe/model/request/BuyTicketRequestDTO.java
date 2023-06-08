package edu.pk.projektProgramowanieObiektowe.model.request;

import edu.pk.projektProgramowanieObiektowe.model.DTO.SeatDTO;

public record BuyTicketRequestDTO(
        Long seanceId,
        String userEmail,
        SeatDTO seat
) {
}
