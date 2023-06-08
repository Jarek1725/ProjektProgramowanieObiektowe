package edu.pk.projektProgramowanieObiektowe.service;

import edu.pk.projektProgramowanieObiektowe.model.entity.SeanceEntity;
import edu.pk.projektProgramowanieObiektowe.model.request.CreateSeanceRequestDTO;
import edu.pk.projektProgramowanieObiektowe.repository.HallRepository;
import edu.pk.projektProgramowanieObiektowe.repository.MovieRepository;
import edu.pk.projektProgramowanieObiektowe.repository.SeanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceService {
    private final SeanceRepository seanceRepository;
    private final MovieRepository movieRepository;
    private final HallRepository hallRepository;

    public SeanceService(SeanceRepository seanceRepository, MovieRepository movieRepository, HallRepository hallRepository) {
        this.seanceRepository = seanceRepository;
        this.movieRepository = movieRepository;
        this.hallRepository = hallRepository;
    }

    public SeanceEntity addSeance(CreateSeanceRequestDTO seanceDTO) {
        // Add any business logic or validation before saving the seanceEntity
        // For example, you could check if the seanceEntity already exists or if it has valid data
        SeanceEntity seance = new SeanceEntity();
        seance.setPrice(seanceDTO.getPrice());
        seance.setDuration(seanceDTO.getDuration());
        seance.setStartTime(seanceDTO.getStartTime());
        seance.setHallEntity(hallRepository.findById(seanceDTO.getHallEntityId()).orElse(null));
        seance.setMovieEntity(movieRepository.findById(seanceDTO.getMovieEntityId()).orElse(null));

        // Save the seanceEntity using the repository
        return seanceRepository.save(seance);
    }

    public List<SeanceEntity> getAllSeances() {
        return seanceRepository.findAll();
    }
}
