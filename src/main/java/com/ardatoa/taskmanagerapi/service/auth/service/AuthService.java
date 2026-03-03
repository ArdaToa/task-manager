package com.ardatoa.taskmanagerapi.service.auth.service;

import com.ardatoa.taskmanagerapi.service.auth.dto.LoginRequest;
import com.ardatoa.taskmanagerapi.service.auth.dto.RegisterRequest;
import com.ardatoa.taskmanagerapi.service.auth.entity.User;
import com.ardatoa.taskmanagerapi.service.auth.repository.UserRepository;
import com.ardatoa.taskmanagerapi.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public String register(RegisterRequest request){

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Bu kullanıcı adı zaten alınmış!");
        }

        User user = new User();
        user.setUsername(request.getUsername());

        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        return "Kullanıcı başarıyla kaydedildi!";
    }

    public String login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        return jwtUtil.generateToken(request.getUsername());
    }
}
