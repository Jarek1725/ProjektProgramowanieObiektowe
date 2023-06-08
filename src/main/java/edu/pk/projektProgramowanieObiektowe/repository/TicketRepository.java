package edu.pk.projektProgramowanieObiektowe.repository;

import edu.pk.projektProgramowanieObiektowe.model.entity.SeanceEntity;
import edu.pk.projektProgramowanieObiektowe.model.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    TicketEntity findAllBySeanceEntityAndColumnSeatAndRowSeat(SeanceEntity seanceEntity, Long columnSeat, Long rowSeat);
}
