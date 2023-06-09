package edu.pk.projektProgramowanieObiektowe.repository;

import edu.pk.projektProgramowanieObiektowe.model.entity.MovieEntity;
import edu.pk.projektProgramowanieObiektowe.model.entity.SeanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SeanceRepository extends JpaRepository<SeanceEntity, Long> {
    List<SeanceEntity> findByMovieEntity(MovieEntity movieEntity);
    List<SeanceEntity> findByStartTimeAfter(LocalDate date);
    @Query("SELECT CASE WHEN EXISTS (SELECT s FROM SeanceEntity s WHERE s.hallEntity.id = :hallId AND s.startTime <= :endTime AND s.endTime >= :startTime) THEN true ELSE false END")
    boolean existsByHallEntityIdAndTimeRange(@Param("hallId") Long hallId,
                                             @Param("startTime") LocalDateTime startTime,
                                             @Param("endTime") LocalDateTime endTime);

    // Add other custom query methods as needed
}
