package edu.pk.projektProgramowanieObiektowe.service;

import edu.pk.projektProgramowanieObiektowe.model.entity.SeanceEntity;
import edu.pk.projektProgramowanieObiektowe.model.request.CreateSeanceRequestDTO;
import edu.pk.projektProgramowanieObiektowe.repository.SeanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceService {
    private final SeanceRepository seanceRepository;

    public SeanceService(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    public SeanceEntity addSeance(CreateSeanceRequestDTO createSeanceRequestDTO) {
//        SeanceEntity seance = new SeanceEntity();
//        seance.setPrice(seanceEntity.getPrice());
//        seance.setDuration(seanceEntity.getDuration());
//        seance.setStartTime(seanceEntity.getStartTime());
//        seance.setHallEntity(seanceEntity.getHallEntity());
//        seance.setMovieEntity(seanceEntity.getMovieEntity());
//        seance.setTicketEntity(seanceEntity.getTicketEntity());
        return null;
//        return seanceRepository.save(seance);
    }

    public List<SeanceEntity> getAllSeances() {
        return seanceRepository.findAll();
    }
}
