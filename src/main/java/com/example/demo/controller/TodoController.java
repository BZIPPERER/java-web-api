package com.example.demo.controller;
//Space for model and service

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.interfaces.TodoItem;
import com.example.demo.interfaces.TodoItemService;
 
import com.example.demo.service.TodoServiceImpl;

import java.util.List;
//Achtung Port 8082!
@RestController
@RequestMapping("/api/v1/TodoItem")
public class TodoController 
{
	TodoItemService TodoItemService;

    public TodoController(TodoServiceImpl TodoItemService) 
    {
        this.TodoItemService = TodoItemService;
    }

  
    
    
    
    
    
    
    @GetMapping
    public ResponseEntity<List<TodoItem>> getAllTodoItems() 
    {
        List<TodoItem> TodoItems = TodoItemService.getTodos();
        return new ResponseEntity<>(TodoItems, HttpStatus.OK);
    }
    //The function receives a GET request, processes it, and gives back a list of TodoItem as a response.
    @GetMapping({"/{TodoItemId}"})
    public ResponseEntity<TodoItem> getTodoItem(@PathVariable Long TodoItemId) {
        return new ResponseEntity<>(TodoItemService.getTodoById(TodoItemId), HttpStatus.OK);
    }
    //The function receives a POST request, processes it, creates a new TodoItem and saves it to the database, and returns a resource link to the created TodoItem.    @PostMapping
    public ResponseEntity<TodoItem> saveTodoItem(@RequestBody TodoItem TodoItem) {
        TodoItem TodoItem1 = TodoItemService.insert(TodoItem);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("TodoItem", "/api/v1/TodoItem/" + TodoItem1.getId().toString());
        return new ResponseEntity<>(TodoItem1, httpHeaders, HttpStatus.CREATED);
    }
    //The function receives a PUT request, updates the TodoItem with the specified Id and returns the updated TodoItem
    @PutMapping({"/{TodoItemId}"})
    public ResponseEntity<TodoItem> updateTodoItem(@PathVariable("TodoItemId") Long TodoItemId, @RequestBody TodoItem TodoItem) {
        TodoItemService.updateTodo(TodoItemId, TodoItem);
        return new ResponseEntity<>(TodoItemService.getTodoById(TodoItemId), HttpStatus.OK);
    }
    //The function receives a DELETE request, deletes the TodoItem with the specified Id.
    @DeleteMapping({"/{TodoItemId}"})
    public ResponseEntity<TodoItem> deleteTodoItem(@PathVariable("TodoItemId") Long TodoItemId) 
    {
        TodoItemService.deleteTodo(TodoItemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
