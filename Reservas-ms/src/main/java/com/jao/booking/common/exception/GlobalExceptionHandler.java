package com.jao.booking.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ReservaNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleReservaNotFound(ReservaNotFoundException ex) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ReservaInvalidaException.class)
    public ResponseEntity<ErrorResponse> handleReservaInvalida(ReservaInvalidaException ex) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneral(Exception ex) {
        return buildErrorResponse("Error interno: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(String mensaje, HttpStatus status) {
        ErrorResponse response = new ErrorResponse(
                status.value(),
                mensaje,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, status);
    }

    public static record ErrorResponse(int status, String message, LocalDateTime timestamp) {}
}

