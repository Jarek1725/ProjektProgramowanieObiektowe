package edu.pk.projektProgramowanieObiektowe.model.request;

public record BuyTicketRequestDTO(
        Long seanceId,
        Long seatId,
        String userEmail,
        String discountName
) {
}
