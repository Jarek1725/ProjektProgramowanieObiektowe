package edu.pk.projektProgramowanieObiektowe.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateHallRequestDTO {
    String name;
    String status;
}
