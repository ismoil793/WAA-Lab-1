package edu.miu.waa.lab.assignments.service.impl;

import edu.miu.waa.lab.assignments.dto.request.LoginRequest;
import edu.miu.waa.lab.assignments.dto.request.RefreshTokenRequest;
import edu.miu.waa.lab.assignments.dto.response.LoginResponse;
import edu.miu.waa.lab.assignments.service.AuthService;
import edu.miu.waa.lab.assignments.util.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            String email = loginRequest.getEmail();
            String password = loginRequest.getPassword();
            var result = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

            final UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            final String accessToken = jwtUtil.generateToken(userDetails);
            final String refreshToken = jwtUtil.generateRefreshToken(email);

            return new LoginResponse(accessToken, refreshToken);
        } catch (BadCredentialsException e) {
            System.out.println("Bad credentials");
            return null;
        }
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        return null;
    }
}
