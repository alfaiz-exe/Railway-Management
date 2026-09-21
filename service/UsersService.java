package com.example.demo.service;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersService {
    UserRepository userRepository;
    public UsersService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Transactional
    public void create(Users users){
        userRepository.save(users);
    }
    @Transactional
    public Users findById(UUID id){
        return userRepository.findById(id);
    }
    @Transactional
    public List<Users> getAll(){
        return userRepository.getAll();
    }

    @Transactional
    public void update(Users users,UUID id){
        Users selectedUser = userRepository.findById(id);
        if (selectedUser == null){
            throw new RuntimeException("User not found");
        }
        selectedUser.setUserType(users.getUserType());
        selectedUser.setUsername(users.getUsername());
        selectedUser.setPasswordHash(users.getPasswordHash());
    }
    @Transactional
    public void delete(UUID id){
        Users users = userRepository.findById(id);
        if (users == null){
            throw new RuntimeException("user not found");
        }
        userRepository.remove(users);
    }
}
