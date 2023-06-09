package edu.pk.projektProgramowanieObiektowe.service;

import edu.pk.projektProgramowanieObiektowe.model.entity.HallEntity;
import edu.pk.projektProgramowanieObiektowe.model.request.CreateHallRequestDTO;
import edu.pk.projektProgramowanieObiektowe.model.request.DeleteHallRequestDTO;
import edu.pk.projektProgramowanieObiektowe.repository.HallRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HallService {
    private final HallRepository hallRepository;

    public List<HallEntity> getAllHalls(){
        return hallRepository.findAll();
    }
    public String createHall(CreateHallRequestDTO hall) {
        hallRepository.save(createHallRequestDTOToHallEntity(hall));
        return "hall added";
    }

    private HallEntity createHallRequestDTOToHallEntity(CreateHallRequestDTO chrDTO){
        HallEntity hall = new HallEntity();
        hall.setStatus(chrDTO.status());
        hall.setName(chrDTO.name());
        hall.setColumnSeats(chrDTO.columnSeats());
        hall.setRowSeats(chrDTO.rowSeats());
        return hall;
    }

    public void /*String*/ deleteHall(DeleteHallRequestDTO id) {
        System.out.println(id.Id());
        hallRepository.deleteById(id.Id());
        /*return "hall deleted";*/
    }
}
