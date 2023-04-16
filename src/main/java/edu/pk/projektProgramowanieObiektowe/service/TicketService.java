package edu.pk.projektProgramowanieObiektowe.service;

import edu.pk.projektProgramowanieObiektowe.model.DTO.BuyTicketRequestDTO;
import edu.pk.projektProgramowanieObiektowe.model.DTO.BuyTicketResponseDTO;
import edu.pk.projektProgramowanieObiektowe.model.DTO.NotFoundCustomException;
import edu.pk.projektProgramowanieObiektowe.model.entity.TicketEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketService {

    public TicketEntity buyTicket(BuyTicketRequestDTO buyTicketDTO) {
        return TicketEntity.builder()
                .seanceEntity(null)
                .seatEntity(null)
                .discountType("TEST")
                .build();
    }
}
