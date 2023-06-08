package edu.pk.projektProgramowanieObiektowe.service;

import edu.pk.projektProgramowanieObiektowe.model.entity.SeanceEntity;
import edu.pk.projektProgramowanieObiektowe.repository.SeanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceService {
    private final SeanceRepository seanceRepository;

    public SeanceService(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    public SeanceEntity addSeance(SeanceEntity seanceEntity) {
        // Add any business logic or validation before saving the seanceEntity
        // For example, you could check if the seanceEntity already exists or if it has valid data
        SeanceEntity seance = new SeanceEntity();
        seance.setPrice(seanceEntity.getPrice());
        seance.setDuration(seanceEntity.getDuration());
        seance.setStartTime(seanceEntity.getStartTime());
        seance.setHallEntity(seanceEntity.getHallEntity());
        seance.setMovieEntity(seanceEntity.getMovieEntity());
        seance.setTicketEntity(seanceEntity.getTicketEntity());
        // Save the seanceEntity using the repository
        return seanceRepository.save(seance);
    }

    public List<SeanceEntity> getAllSeances() {
        return seanceRepository.findAll();
    }
}
