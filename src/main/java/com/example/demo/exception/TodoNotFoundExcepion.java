package com.example.demo.exception;

public class TodoNotFoundExcepion extends RuntimeException{
    public TodoNotFoundExcepion() {
    }

    public TodoNotFoundExcepion(Long i) {
        super("Todo id = "+i+" not found");
    }
}
