package edu.pk.projektProgramowanieObiektowe.service;

import edu.pk.projektProgramowanieObiektowe.model.entity.HallEntity;
import edu.pk.projektProgramowanieObiektowe.model.request.CreateHallRequestDTO;
import edu.pk.projektProgramowanieObiektowe.repository.HallRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class HallService {
    private final HallRepository hallRepository;
    public String createHall(CreateHallRequestDTO hall) {
        hallRepository.save(createHallRequestDTOToHallEntity(hall));
        return "Dodano sale";
    }

    private HallEntity createHallRequestDTOToHallEntity(CreateHallRequestDTO chrDTO){
        HallEntity hall = new HallEntity();
        hall.setStatus(chrDTO.getStatus());
        hall.setName(chrDTO.getName());
        return hall;
    }
}
