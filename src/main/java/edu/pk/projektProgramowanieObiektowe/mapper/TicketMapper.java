package edu.pk.projektProgramowanieObiektowe.mapper;

import edu.pk.projektProgramowanieObiektowe.model.DTO.TicketDTO;
import edu.pk.projektProgramowanieObiektowe.model.request.BuyTicketRequestDTO;
import edu.pk.projektProgramowanieObiektowe.model.response.BuyTicketResponseDTO;
import edu.pk.projektProgramowanieObiektowe.model.entity.TicketEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TicketMapper {
    TicketDTO toTicketDTO(TicketEntity ticketEntity);

    TicketEntity toTicketEntity(BuyTicketRequestDTO buyTicketRequestDTO);
}
