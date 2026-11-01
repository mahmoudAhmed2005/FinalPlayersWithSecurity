package com.first_springboot.demo.service;

import com.first_springboot.demo.controller.vm.LoginRequest;
import jakarta.transaction.SystemException;

public interface AuthService {

    String login(LoginRequest request) throws SystemException;
}
