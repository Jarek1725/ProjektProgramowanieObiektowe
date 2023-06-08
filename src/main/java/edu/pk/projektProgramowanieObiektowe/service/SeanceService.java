package edu.pk.projektProgramowanieObiektowe.service;

import edu.pk.projektProgramowanieObiektowe.model.entity.MovieEntity;
import edu.pk.projektProgramowanieObiektowe.model.entity.SeanceEntity;
import edu.pk.projektProgramowanieObiektowe.model.exception.CannotCreateCustomException;
import edu.pk.projektProgramowanieObiektowe.model.request.CreateSeanceRequestDTO;
import edu.pk.projektProgramowanieObiektowe.repository.HallRepository;
import edu.pk.projektProgramowanieObiektowe.repository.MovieRepository;
import edu.pk.projektProgramowanieObiektowe.repository.SeanceRepository;
import org.springframework.stereotype.Service;

import javax.swing.undo.CannotRedoException;
import java.time.LocalDateTime;
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

    public LocalDateTime calculateEndTime(LocalDateTime startTime, Integer duration) {
        if (startTime != null && duration != null) {
            return startTime.plusMinutes(duration);
        }
        return null;
    }
    public SeanceEntity addSeance(CreateSeanceRequestDTO seanceDTO) {
        MovieEntity movieEntity = movieRepository.findById(seanceDTO.getMovieEntityId()).orElse(null);

        LocalDateTime startTime = seanceDTO.getStartTime();
        Integer duration = movieEntity.getDuration();
        LocalDateTime endTime = calculateEndTime(startTime, duration);
        Long hallId = seanceDTO.getHallEntityId();
        System.out.println("sT: " + startTime + " | dur: " + duration + " | eT: " + endTime);

        boolean seanceConflictExists = seanceRepository.existsByHallEntityIdAndTimeRange(hallId, startTime, endTime);

        if (seanceConflictExists) {
            throw new CannotCreateCustomException(SeanceEntity.class,"Hall is occupied");
        }

        SeanceEntity seance = new SeanceEntity();
        seance.setPrice(seanceDTO.getPrice());
        seance.setEndTime(endTime);
        seance.setStartTime(seanceDTO.getStartTime());
        seance.setHallEntity(hallRepository.findById(seanceDTO.getHallEntityId()).orElse(null));
        seance.setMovieEntity(movieRepository.findById(seanceDTO.getMovieEntityId()).orElse(null));

        return seanceRepository.save(seance);
    }

    public List<SeanceEntity> getAllSeances() {
        return seanceRepository.findAll();
    }
}
