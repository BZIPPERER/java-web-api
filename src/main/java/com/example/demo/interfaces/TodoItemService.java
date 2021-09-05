package com.example.demo.interfaces;

import java.util.List;

public interface TodoItemService 
{
    List<TodoItem> getTodos();

    TodoItem getTodoById(Long id);

    TodoItem insert(TodoItem todo);

    void updateTodo(Long id, TodoItem todo);

    void deleteTodo(Long todoId);
}