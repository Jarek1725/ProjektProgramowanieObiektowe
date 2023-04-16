package edu.pk.projektProgramowanieObiektowe.service;

import edu.pk.projektProgramowanieObiektowe.model.request.BuyTicketRequestDTO;
import edu.pk.projektProgramowanieObiektowe.model.entity.TicketEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketService {

    public TicketEntity buyTicket(BuyTicketRequestDTO ticketEntity) {
        return TicketEntity.builder()
                .seanceEntity(null)
                .seatEntity(null)
                .discountType("TEST")
                .build();
    }
}
