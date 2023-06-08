package edu.pk.projektProgramowanieObiektowe.model.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class NotFoundCustomException extends RuntimeException {
    private Class<?> objectType;

    public NotFoundCustomException(Long id, Class<?> objectType) {
        super(objectType.getSimpleName() +  " with id: " + id + " not found");
    }
}
