package com.example.miniproject.service;

import com.example.miniproject.model.Todo;
import com.example.miniproject.request.CreateTodoRequest;
import com.example.miniproject.request.UpdateTodoRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    public List<Todo> todos;

    public TodoService() {
        todos = new ArrayList<>();
        todos.add(new Todo(1, "Đi chơi", true));
        todos.add(new Todo(2, "Làm bài tập", false));
        todos.add(new Todo(3, "Đá bóng", true));
    }

    public List<Todo> getTodos() {
    }

    public Todo createTodo(CreateTodoRequest request) {
    }

    public Todo updateTodo(int id, UpdateTodoRequest request) {
    }

    public void deleteTodo(int id) {
    }
}
