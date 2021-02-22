package com.example.demo.controller;

import com.example.demo.exception.TodoNotFoundExcepion;
import com.example.dto.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TodoController {

    private List<Todo> todo = new ArrayList<>();
    private final AtomicLong couter = new AtomicLong();

    public TodoController() {
        todo.add(new Todo(1L,"one"));
        todo.add(new Todo(2L,"two"));
        todo.add(new Todo(3L,"three"));
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/todo")
    public List<Todo> getTodos(){
            return todo;
    }

    @GetMapping("/todo/{id}")
    public Todo getTodo(@PathVariable int id){
        List<Todo> todos = this.todo;
        return todos.stream().filter((val)-> val.getId() == id).findFirst().orElse(null);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/todo")
    public void addTodo(@RequestBody Todo todo){
         this.todo.add(new Todo(this.couter.getAndIncrement(),todo.getName()));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/todo/{id}")
    public void removeTodo(@PathVariable Long id){
        List<Todo> todos = this.todo;
        todos.stream().filter((val) -> val.getId() == id).findFirst().ifPresentOrElse((val) -> {
            todos.remove(val);
        }, () -> {
            throw new TodoNotFoundExcepion(id);
        });
    }
}
