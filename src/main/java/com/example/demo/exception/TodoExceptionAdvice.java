package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@ControllerAdvice
public class TodoExceptionAdvice {
    public TodoExceptionAdvice() {
    }

    @ResponseBody
    @ExceptionHandler(TodoNotFoundExcepion.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    HashMap<String, String> todoNotFound(TodoNotFoundExcepion e){
        HashMap<String,String> error = new HashMap<>();
        error.put("message",e.getMessage());
        return error;
    }
}
