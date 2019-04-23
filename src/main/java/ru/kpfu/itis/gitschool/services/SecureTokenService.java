package ru.kpfu.itis.gitschool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SecureTokenService {
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public String getToken() {
        return UUID.randomUUID().toString();
//        passwordEncoder.
    }
}
