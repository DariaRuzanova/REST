package com.example.controller;

import com.example.model.User;
import com.example.repository.Authorities;
import com.example.service.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")

    public List<Authorities> getAuthorities(@Valid User user) {
        var result = service.getAuthorities(user);
        return result;
    }
}

