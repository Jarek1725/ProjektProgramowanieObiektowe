package edu.pk.projektProgramowanieObiektowe.model.DTO;

import java.util.HashSet;

public record HallDTO(
        String name,
        String status,
        HashSet<SeanceDTO> seanceDTO
) {
}
