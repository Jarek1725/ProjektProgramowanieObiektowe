package edu.pk.projektProgramowanieObiektowe.controller;

import edu.pk.projektProgramowanieObiektowe.model.entity.HallEntity;
import edu.pk.projektProgramowanieObiektowe.model.request.CreateHallRequestDTO;
import edu.pk.projektProgramowanieObiektowe.model.response.CreateHallResponseDTO;
import edu.pk.projektProgramowanieObiektowe.repository.HallRepository;
import edu.pk.projektProgramowanieObiektowe.service.HallService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hall")
@AllArgsConstructor
public class HallController {
    private final HallRepository hallRepository;
    private final HallService hallService;

    @GetMapping
    public List<HallEntity> getAllHalls(){
        return hallRepository.findAll();
    }
    @PostMapping("/add")
    public ResponseEntity<?> createHall(@RequestBody CreateHallRequestDTO hall) {
        hallService.createHall(hall);
        return ResponseEntity.ok("test");

    }
}
