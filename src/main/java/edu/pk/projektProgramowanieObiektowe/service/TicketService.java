package edu.pk.projektProgramowanieObiektowe.service;

import edu.pk.projektProgramowanieObiektowe.model.exception.CannotCreateCustomException;
import edu.pk.projektProgramowanieObiektowe.model.exception.NotFoundCustomException;
import edu.pk.projektProgramowanieObiektowe.model.entity.TicketEntity;
import edu.pk.projektProgramowanieObiektowe.repository.SeanceRepository;
import edu.pk.projektProgramowanieObiektowe.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketService {

    private final SeanceRepository seanceRepository;
    private final TicketRepository ticketRepository;

    public TicketEntity buyTicket(TicketEntity ticketEntity) {
        ticketEntity.setSeanceEntity(seanceRepository.findById(ticketEntity.getSeanceEntity().getId()).orElseThrow(
                () -> new CannotCreateCustomException(TicketEntity.class, "seance doesn't exist")
        ));

        if(!isValidSeat(ticketEntity)){
            throw new CannotCreateCustomException(TicketEntity.class, "seat is already taken or didn't exist");
        }

        TicketEntity savedTicket = ticketRepository.save(ticketEntity);

        if (savedTicket.getId() == null) {
            throw new CannotCreateCustomException(TicketEntity.class, "Server error");
        }

        return savedTicket;
    }

    private boolean isValidSeat(TicketEntity ticketEntity) {
        return (doesSeatExist(ticketEntity) && ticketRepository.findAllBySeanceEntityAndColumnSeatAndRowSeat(
                ticketEntity.getSeanceEntity(),
                ticketEntity.getColumnSeat(),
                ticketEntity.getRowSeat()) == null);
    }

    public TicketEntity findTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(
                () -> new NotFoundCustomException(id, TicketEntity.class)
        );
    }

    private boolean doesSeatExist(TicketEntity ticket) {
        return ticket.getRowSeat() > 0 && ticket.getRowSeat() <= ticket.getSeanceEntity().getHallEntity().getRowSeats() &&
                ticket.getColumnSeat() > 0 && ticket.getColumnSeat() <= ticket.getSeanceEntity().getHallEntity().getColumnSeats();
    }
}
