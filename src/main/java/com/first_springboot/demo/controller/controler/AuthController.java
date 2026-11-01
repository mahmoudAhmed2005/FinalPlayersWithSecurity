package com.first_springboot.demo.controller.controler;

import com.first_springboot.demo.controller.vm.LoginRequest;
import com.first_springboot.demo.service.AuthService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
//    @PreAuthorize("permitAll()")
    public ResponseEntity<String> login(
            @RequestBody LoginRequest request) throws SystemException {

        return ResponseEntity.ok(authService.login(request));
    }
}