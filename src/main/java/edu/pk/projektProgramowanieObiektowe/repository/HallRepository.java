package edu.pk.projektProgramowanieObiektowe.repository;

import edu.pk.projektProgramowanieObiektowe.model.entity.HallEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository <HallEntity, Long>{
//    @Query("select * from HallEntity as hall where: ")
    HallEntity findByName(String name);
}

