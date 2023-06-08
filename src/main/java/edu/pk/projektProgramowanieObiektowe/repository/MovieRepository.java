package edu.pk.projektProgramowanieObiektowe.repository;

import edu.pk.projektProgramowanieObiektowe.model.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    // Dodatkowe metody dostępu do danych można zadeklarować tutaj
}