package com.first_springboot.demo.controller.vm;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class LoginRequest {

    private String email;
    private String password;
}
