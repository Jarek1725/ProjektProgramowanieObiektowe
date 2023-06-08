package edu.pk.projektProgramowanieObiektowe.controller;

import edu.pk.projektProgramowanieObiektowe.model.entity.SeanceEntity;
import edu.pk.projektProgramowanieObiektowe.service.SeanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seance")
public class SeanceController {
    private final SeanceService seanceService;

    // Inject the SeanceService or SeanceRepository dependency using constructor injection
    public SeanceController(SeanceService seanceService) {
        this.seanceService = seanceService;
    }
    @GetMapping
    public ResponseEntity<List<SeanceEntity>> getAllSeances() {
        List<SeanceEntity> seances = seanceService.getAllSeances();
        return ResponseEntity.ok(seances);
    }
    @PostMapping("/add")
    public ResponseEntity<SeanceEntity> addSeance(@RequestBody SeanceEntity seanceEntity) {
        // Logic for creating and saving a new SeanceEntity
        SeanceEntity createdSeance = seanceService.addSeance(seanceEntity);

        // Return the newly created SeanceEntity in the response with a success status
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSeance);
    }
}
