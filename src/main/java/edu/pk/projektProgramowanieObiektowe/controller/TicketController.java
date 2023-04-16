package edu.pk.projektProgramowanieObiektowe.controller;

import edu.pk.projektProgramowanieObiektowe.mapper.TicketMapper;
import edu.pk.projektProgramowanieObiektowe.model.DTO.BuyTicketRequestDTO;
import edu.pk.projektProgramowanieObiektowe.model.entity.TicketEntity;
import edu.pk.projektProgramowanieObiektowe.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
public class TicketController {

    private final TicketService ticketService;
    private final TicketMapper ticketMapper;
    @PostMapping("/buy")
    public ResponseEntity<?> buyTicket(@RequestBody BuyTicketRequestDTO buyTicketDTO) {
        TicketEntity ticketEntity = ticketService.buyTicket(buyTicketDTO);
        return new ResponseEntity<>(ticketMapper.toBuyTicketResponseDTO(ticketEntity), HttpStatus.OK);
    }
}
