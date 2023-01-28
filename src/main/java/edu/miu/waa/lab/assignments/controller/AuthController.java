package edu.miu.waa.lab.assignments.controller;

import edu.miu.waa.lab.assignments.dto.request.LoginRequest;
import edu.miu.waa.lab.assignments.dto.request.RefreshTokenRequest;
import edu.miu.waa.lab.assignments.dto.response.LoginResponse;
import edu.miu.waa.lab.assignments.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        System.out.println(loginResponse);
        return ResponseEntity.ok().body(loginResponse);
    }
    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }
}
