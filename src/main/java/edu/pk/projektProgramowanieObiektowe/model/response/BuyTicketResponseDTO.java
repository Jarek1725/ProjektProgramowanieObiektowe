package edu.pk.projektProgramowanieObiektowe.model.response;

import edu.pk.projektProgramowanieObiektowe.model.DTO.SeanceDTO;
import edu.pk.projektProgramowanieObiektowe.model.DTO.TicketDTO;

import java.util.UUID;

public record BuyTicketResponseDTO(
        TicketDTO ticket,
        SeanceDTO seance,
        String discountType,
        Long seatId
) {
}
