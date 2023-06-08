package edu.pk.projektProgramowanieObiektowe.model.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CannotCreateCustomException extends RuntimeException{
    private Class<?> objectType;

    public CannotCreateCustomException(Class<?> objectType, String msg) {
        super("Cannot create: "+objectType.getSimpleName()+", message: "+msg);
    }
}
