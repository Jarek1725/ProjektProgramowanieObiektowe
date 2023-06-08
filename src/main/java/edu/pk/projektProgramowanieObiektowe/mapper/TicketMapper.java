package edu.pk.projektProgramowanieObiektowe.mapper;

import edu.pk.projektProgramowanieObiektowe.model.DTO.TicketDTO;
import edu.pk.projektProgramowanieObiektowe.model.entity.TicketEntity;
import edu.pk.projektProgramowanieObiektowe.model.request.BuyTicketRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TicketMapper {

    @Mapping(target="seanceEntity.id", source = "seanceId")
    @Mapping(target="columnSeat", source = "seat.row")
    @Mapping(target="rowSeat", source = "seat.column")
    TicketEntity toTicketEntity(BuyTicketRequestDTO buyTicketRequestDTO);

    @Mapping(target="movieTitle", source = "seanceEntity.movieEntity.title")
    @Mapping(target="ticketId", source = "id")
    TicketDTO toTicketDTO(TicketEntity result);
}
