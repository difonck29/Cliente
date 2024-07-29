package co.fonseca.diego.Cliente.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@RestControllerAdvice
public class ControllerExceptionHandler {
  
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
      ErrorMessage message = new ErrorMessage(
          HttpStatus.NOT_FOUND.value(),
          new Date(),
          ex.getMessage(),
          request.getDescription(false));
      
      return message;
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage badRequestException(BadRequestException ex,WebRequest request) {
        System.out.println("Entro al error");
        ErrorMessage message = new ErrorMessage(
          HttpStatus.BAD_REQUEST.value(),
          new Date(),
          ex.getMessage(),
          request.getDescription(false));
      
      return message;
    }

    @ExceptionHandler(Exception.class)
    public ErrorMessage handle(Exception ex,
            WebRequest request) {
                System.out.println("Error");
                ErrorMessage message = new ErrorMessage(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    new Date(),
                    ex.getMessage(),
                    request.getDescription(false));        
        return message;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler(MethodArgumentNotValidException.class)
public Map<String, String> handleValidationExceptions(
  MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
        String fieldName = ((FieldError) error).getField();
        String errorMessage = error.getDefaultMessage();
        errors.put(fieldName, errorMessage);
    });
    return errors;
}

}