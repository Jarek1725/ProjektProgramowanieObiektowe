package edu.pk.projektProgramowanieObiektowe.model.DTO;

public record BuyTicketRequestDTO(
        Long seanceId,
        Long seatId,
        String userEmail,
        String discountName
) {
}
