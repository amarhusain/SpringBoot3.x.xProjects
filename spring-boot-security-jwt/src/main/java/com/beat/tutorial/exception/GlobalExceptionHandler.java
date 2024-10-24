package com.beat.tutorial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public final ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException ex, WebRequest request) {
        return new ResponseEntity<>(
            generateErrorResponse("CONFLICT", ex.getMessage(), request.getDescription(false)),
            HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(
            generateErrorResponse("NOT_FOUND", ex.getMessage(), request.getDescription(false)),
            HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException ex, WebRequest request) {
       return new ResponseEntity<>(
           generateErrorResponse("BAD_REQUEST", ex.getMessage(), request.getDescription(false)),
           HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                generateErrorResponse( "INTERNAL_SERVER_ERROR", ex.getMessage(), request.getDescription(false)),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public final ResponseEntity<ErrorResponse> unauthorizedException(UnauthorizedException ex, WebRequest request) {
        return new ResponseEntity<>(
            generateErrorResponse( "UNAUTHORIZED", ex.getMessage(), request.getDescription(false)),
            HttpStatus.UNAUTHORIZED);
    }

    private ErrorResponse generateErrorResponse(String errorCode, String errorMessage, String errorDetail) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(errorCode);
        errorResponse.setErrorMessage(errorMessage);
        errorResponse.setErrorDetail(errorDetail);
        errorResponse.setTimestamp(LocalDateTime.now());
        return errorResponse;
    }
}

