package ir.mapsa.springatm.exeptions;

import ir.mapsa.springatm.enums.ExpMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExeptionHandler {



    @ExceptionHandler(value = NotFoundExeption.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleNotFoundException(NotFoundExeption exp) {
        Map<String, String> exmas = new HashMap<>();
        exmas.put(ExpMessages.NOT_FOUND.name(), exp.getMessage());
        return new ResponseEntity<>(exmas, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<?> handleConflictException(ConflictException exp) {
        Map<String, String> exres = new HashMap<>();
        exres.put(ExpMessages.DUPLICATE_INPUT.toString(), exp.getMessage());
        return new ResponseEntity<>(exres, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseStatus(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE)
    public ResponseEntity<?> handleBusinessException(BusinessException exp) {
        Map<String, String> exres = new HashMap<>();
        exres.put(ExpMessages.BUSINESS_ERROR.name(), exp.getMessage());
        return new ResponseEntity<>(exres, HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<?> handleRuntimeException(RuntimeException exp) {
        Map<String, String> exres = new HashMap<>();
        exres.put(ExpMessages.ID_NOT_EXIST.toString(), exp.getMessage());
        return new ResponseEntity<>(exres, HttpStatus.NOT_ACCEPTABLE);
    }
}
