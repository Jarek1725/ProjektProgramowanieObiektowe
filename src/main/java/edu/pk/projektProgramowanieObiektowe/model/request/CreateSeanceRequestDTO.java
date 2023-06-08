package edu.pk.projektProgramowanieObiektowe.model.request;

import edu.pk.projektProgramowanieObiektowe.model.entity.HallEntity;
import edu.pk.projektProgramowanieObiektowe.model.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CreateSeanceRequestDTO {
    private LocalDate startTime;
    private Double price;
    private Long hallEntityId;
    private Long movieEntityId;
    private Integer duration;
}
