package com.example.demo.api;

import com.example.demo.model.Users;
import com.example.demo.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class UserController {
    UsersService usersService;
    public UserController(UsersService usersService){
        this.usersService = usersService;
    }
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody Users users){
        usersService.create(users);
        return ResponseEntity.ok("Done");
    }
    @GetMapping("/{id}")
    public Optional<Users> findById(@PathVariable UUID id){
        return Optional.of(usersService.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Users users,
                                         @PathVariable UUID id){
        usersService.update(users,id);
        return ResponseEntity.ok("ok");
    }
    @GetMapping
    public List<Users> getAll(){
        return usersService.getAll();
    }
}
