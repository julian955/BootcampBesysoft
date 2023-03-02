package com.bootcamp.besysoft.controlador.handlerController;

import com.bootcamp.besysoft.dto.dto.ExceptionDTO;
import com.bootcamp.besysoft.excepciones.InvalidNameException;
import com.bootcamp.besysoft.excepciones.NullEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice(annotations = RestController.class)
public class ApiControllerAdvice {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO exceptionHandler(MethodArgumentNotValidException ex){
        List<FieldError> errorList = ex.getBindingResult().getFieldErrors();
        Map<String,String> details = new HashMap<>();
        errorList.forEach( e -> details.put(e.getField(),e.getDefaultMessage()));

        return new ExceptionDTO(HttpStatus.BAD_REQUEST.value(),"Validacion",details);
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO invalidNameHandler(InvalidNameException ex){
        return new ExceptionDTO(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                null
        );
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO nullEntityHandler(NullEntityException ex){
        return new ExceptionDTO(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                null
        );
    }
}
