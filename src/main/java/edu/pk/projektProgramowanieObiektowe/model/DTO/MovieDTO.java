package edu.pk.projektProgramowanieObiektowe.model.DTO;

import java.util.HashSet;

public record MovieDTO(
        String title,
        Integer duration,
        String description,
        String genre,
        String director,
        String actors,
        HashSet<SeanceDTO> seanceDTOs
) {
}
