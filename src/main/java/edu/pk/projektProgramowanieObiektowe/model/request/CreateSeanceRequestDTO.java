package edu.pk.projektProgramowanieObiektowe.model.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateSeanceRequestDTO {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double price;
    private Long hallEntityId;
    private Long movieEntityId;
    private Integer duration;
}
