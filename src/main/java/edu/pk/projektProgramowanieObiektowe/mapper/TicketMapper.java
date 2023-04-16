package edu.pk.projektProgramowanieObiektowe.mapper;

import edu.pk.projektProgramowanieObiektowe.model.DTO.BuyTicketResponseDTO;
import edu.pk.projektProgramowanieObiektowe.model.entity.TicketEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TicketMapper {
    BuyTicketResponseDTO toBuyTicketResponseDTO(TicketEntity ticketEntity);
}
