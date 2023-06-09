package edu.pk.projektProgramowanieObiektowe.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record CreateHallRequestDTO(
        String name,
        String status,
        Long rowSeats,
        Long columnSeats
){}
