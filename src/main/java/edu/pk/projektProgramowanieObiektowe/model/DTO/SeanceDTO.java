package edu.pk.projektProgramowanieObiektowe.model.DTO;

import java.time.LocalDate;
import java.util.HashSet;

public record SeanceDTO(
    Double price,
    LocalDate startTime,
    HallDTO hallDTO,
    MovieDTO movieDTO,
    HashSet<TicketDTO> ticketDTOs
) {
}
