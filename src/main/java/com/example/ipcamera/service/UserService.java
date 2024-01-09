package com.example.ipcamera.service;

import com.example.ipcamera.entity.UserEntity;
import com.example.ipcamera.exceptions.UserAlredyExistException;
import com.example.ipcamera.exceptions.UserNotFoundEception;
import com.example.ipcamera.model.User;
import com.example.ipcamera.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlredyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlredyExistException("User with this name already exists");
        }

        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundEception {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundEception("User wasn't found");
        }

        return User.toModel(user);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);

        return id;
    }
}
