package com.example.demo.service;

 
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.TodoItem;
import com.example.demo.interfaces.TodoItemService;
import com.example.demo.repositories.TodoItemRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoItemService 
{
    TodoItemRepository todoRepository;

    public TodoServiceImpl(TodoItemRepository todoRepository) 
    {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<TodoItem> getTodos() 
    {
        List<TodoItem> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);
        return todos;
    }

    @Override
    public TodoItem getTodoById(Long id) 
    {
        return todoRepository.findById(id).get();
    }
//****
    @Override
    public TodoItem insert(TodoItem todo) 
    {
        return todoRepository.save(todo);
    }

    @Override
    public void updateTodo(Long id, TodoItem todo) 
    {
        //find by id
    	TodoItem todoFromDb = 
        		todoRepository.findById(id).get();
        System.out.println("DB Eintrag "+todoFromDb.toString()+" wird geändert..");
        // set todo status new
        todoFromDb.setTodoStatus(todo.getTodoStatus());
        // .. ALL PROPS
        todoFromDb.setDescription(todo.getDescription());
        // .. ALL PROPS
        todoFromDb.setTitle(todo.getTitle());
        // save
        todoRepository.save(todoFromDb);
    }

    @Override
    public void deleteTodo(Long todoId) 
    {
        todoRepository.deleteById(todoId);
    }
}
