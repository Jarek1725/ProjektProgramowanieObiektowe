package edu.pk.projektProgramowanieObiektowe.model.DTO;

public record BuyTicketResponseDTO(
        Long ticketId,
        Long seanceId,
        Double price,
        String userEmail,
        String discountType
) {
}
