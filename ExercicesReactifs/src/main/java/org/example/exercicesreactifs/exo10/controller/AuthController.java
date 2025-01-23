package org.example.exercicesreactifs.exo10.controller;


import org.example.exercicesreactifs.exo10.jwt.JwtService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String role;
        if (credentials.get("role") != null) {
            role = credentials.get("role");
        }else{
            role = "admin";
        }
        return jwtService.generateToken(username,Map.of("role", role));
    }
}
