package edu.pk.projektProgramowanieObiektowe.controller;

import edu.pk.projektProgramowanieObiektowe.mapper.TicketMapper;
import edu.pk.projektProgramowanieObiektowe.model.request.BuyTicketRequestDTO;
import edu.pk.projektProgramowanieObiektowe.model.entity.TicketEntity;
import edu.pk.projektProgramowanieObiektowe.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
public class TicketController {

    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    @PostMapping("/buy")
    public ResponseEntity<?> buyTicket(@RequestBody BuyTicketRequestDTO buyTicketRequestDTO) {
        TicketEntity result = ticketService.buyTicket(ticketMapper.toTicketEntity(buyTicketRequestDTO));
        return ResponseEntity.ok(ticketMapper.toTicketDTO(result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTicketById(@PathVariable Long id) {
        TicketEntity ticket = ticketService.findTicketById(id);
        return ResponseEntity.ok(ticketMapper.toTicketDTO(ticket));
    }
}
