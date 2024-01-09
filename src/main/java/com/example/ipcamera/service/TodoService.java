package com.example.ipcamera.service;

import com.example.ipcamera.entity.TodoEntity;
import com.example.ipcamera.entity.UserEntity;
import com.example.ipcamera.model.Todo;
import com.example.ipcamera.repository.TodoRepo;
import com.example.ipcamera.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);

        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo choseTodo(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setChose(!todo.getChose());

        return Todo.toModel(todoRepo.save(todo));
    }
}
