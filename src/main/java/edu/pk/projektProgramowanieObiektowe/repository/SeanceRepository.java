package edu.pk.projektProgramowanieObiektowe.repository;

import edu.pk.projektProgramowanieObiektowe.model.entity.MovieEntity;
import edu.pk.projektProgramowanieObiektowe.model.entity.SeanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SeanceRepository extends JpaRepository<SeanceEntity, Long> {
    List<SeanceEntity> findByMovieEntity(MovieEntity movieEntity);
    List<SeanceEntity> findByStartTimeAfter(LocalDate date);
    // Add other custom query methods as needed
}
