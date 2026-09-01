package dev.nidhi.fakestoreapis.advices;

import dev.nidhi.fakestoreapis.dtos.ErrorResponseDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return "Error: " + e.getMessage();
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDTO handleRuntimeException(RuntimeException e){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessage(e.getMessage());
        errorResponseDTO.setStatus("500");
        return errorResponseDTO;
    }
}
