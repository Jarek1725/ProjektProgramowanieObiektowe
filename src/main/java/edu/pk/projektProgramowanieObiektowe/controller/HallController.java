package edu.pk.projektProgramowanieObiektowe.controller;

import edu.pk.projektProgramowanieObiektowe.model.entity.HallEntity;
import edu.pk.projektProgramowanieObiektowe.model.request.CreateHallRequestDTO;
import edu.pk.projektProgramowanieObiektowe.model.request.DeleteHallRequestDTO;
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
    private final HallService hallService;

    @GetMapping
    public List<HallEntity> getAllHalls(){
        return hallService.getAllHalls();
    }
    @PostMapping("/add")
    public ResponseEntity<?> createHall(@RequestBody CreateHallRequestDTO hall) {
        hallService.createHall(hall);
        return ResponseEntity.ok("hall added");

    }

    @DeleteMapping("{hallId}")
    public void /*ResponseEntity<?>*/ deleteHall(@PathVariable("hallId") @RequestBody DeleteHallRequestDTO id){
        hallService.deleteHall(id);
        /*return ResponseEntity.ok("hall deleted");*/
    }
}
