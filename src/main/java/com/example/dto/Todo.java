package com.example.dto;

import lombok.Data;

@Data
public class Todo {
    private Long id;
    private String name;

    public Todo(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
