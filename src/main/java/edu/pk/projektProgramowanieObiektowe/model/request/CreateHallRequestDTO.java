package edu.pk.projektProgramowanieObiektowe.model.request;

public record CreateHallRequestDTO(
        String name,
        String status,
        Long rowSeats,
        Long columnSeats
){}
