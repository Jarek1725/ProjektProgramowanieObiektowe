package edu.pk.projektProgramowanieObiektowe.model.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

public record SeanceDTO(
    Double price,
    LocalDateTime startTime,
    HallDTO hallDTO,
    MovieDTO movieDTO,
    HashSet<TicketDTO> ticketDTOs
) {
}
