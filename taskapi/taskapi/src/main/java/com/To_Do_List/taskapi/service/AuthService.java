package com.To_Do_List.taskapi.service;

import com.To_Do_List.taskapi.auth.LoginRequest;
import com.To_Do_List.taskapi.auth.RegisterRequest;
import com.To_Do_List.taskapi.model.User;
import com.To_Do_List.taskapi.repository.UserRepository;
import com.To_Do_List.taskapi.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public String register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return jwtService.generateToken(user.getUsername());
    }

    public String login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        return jwtService.generateToken(request.getUsername());
    }
}