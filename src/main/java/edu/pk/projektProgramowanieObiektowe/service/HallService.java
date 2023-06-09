package edu.pk.projektProgramowanieObiektowe.service;

import edu.pk.projektProgramowanieObiektowe.model.entity.HallEntity;
import edu.pk.projektProgramowanieObiektowe.model.exception.CannotCreateCustomException;
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

    public void  deleteHall(Long id) {
        HallEntity hall = hallRepository.findById(id).orElse(null);
        if (hall != null) {
            hallRepository.delete(hall);
        } else {
            throw new CannotCreateCustomException(HallEntity.class, "cannot delete hall");
        }
    }

    public HallEntity createHallRequestDTOToHallEntity(CreateHallRequestDTO chrDTO){
        if( hallRepository.existsByName(chrDTO.name() )){
            throw new CannotCreateCustomException(HallEntity.class, "name already exists");
        }

        HallEntity hall = new HallEntity();
        hall.setStatus(chrDTO.status());
        hall.setName(chrDTO.name());
        hall.setColumnSeats(chrDTO.columnSeats());
        hall.setRowSeats(chrDTO.rowSeats());

        return hallRepository.save(hall);
    }
}
