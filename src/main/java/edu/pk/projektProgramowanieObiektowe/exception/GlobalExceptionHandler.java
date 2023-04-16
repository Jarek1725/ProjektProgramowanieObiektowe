package edu.pk.projektProgramowanieObiektowe.exception;

import edu.pk.projektProgramowanieObiektowe.model.exception.NotFoundCustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundCustomException.class)
    public ResponseEntity<String> handleCustomException(NotFoundCustomException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        log.error("Error at: Line: {}, File: {}", ex.getStackTrace()[0].getLineNumber(), ex.getStackTrace()[0].getFileName());
        log.error("Error: " + ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), status);
    }
}
