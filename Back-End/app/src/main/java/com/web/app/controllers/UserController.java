package com.web.app.controllers;

import com.web.app.dto.DTOReq.UserDTOReq;
import com.web.app.dto.DTORes.UserDTORes;
import com.web.app.servis.UserServis;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor

public class UserController {

    private final UserServis userService;

    @PostMapping
    public ResponseEntity<UserDTORes> createUser(@Valid @RequestBody UserDTOReq userDTOReq) {
        UserDTORes userDTORes = userService.createUser(userDTOReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTORes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTORes> getUserById(@PathVariable Long id) {
        UserDTORes userDTORes = userService.getUserById(id);
        return ResponseEntity.ok(userDTORes);
    }

    @GetMapping
    public ResponseEntity<List<UserDTORes>> getAllUsers() {
        List<UserDTORes> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
