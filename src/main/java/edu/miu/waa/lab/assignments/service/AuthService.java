package edu.miu.waa.lab.assignments.service;

import edu.miu.waa.lab.assignments.dto.request.LoginRequest;
import edu.miu.waa.lab.assignments.dto.request.RefreshTokenRequest;
import edu.miu.waa.lab.assignments.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
