package com.first_springboot.demo.service.impl;

import com.first_springboot.demo.config.token.TokenHandler;
import com.first_springboot.demo.controller.vm.LoginRequest;
import com.first_springboot.demo.dto.AccountDto;
import com.first_springboot.demo.service.AccountService;
import com.first_springboot.demo.service.AuthService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private AccountService accountService;
    private PasswordEncoder passwordEncoder;
    private TokenHandler tokenHandler;

    @Autowired
    public AuthServiceImpl(AccountService accountService, PasswordEncoder passwordEncoder, TokenHandler tokenHandler) {
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
        this. tokenHandler =  tokenHandler;
    }

    @Override
    public String login(LoginRequest request) throws SystemException {
        try {

         AccountDto accountDto = accountService.getByEmail(request.getEmail());

//         if (!passwordEncoder.matches(request.getPassword(),accountDto.getPassword())){
//             throw new SystemException("user.invalid.password");
//         }

            if (!request.getPassword().equals(accountDto.getPassword())) {
                throw new SystemException("user.invalid.password");
            }


         return tokenHandler.createToken(accountDto);

        } catch (SystemException e) {
            throw new SystemException("user.invalid.dataaaaa");
        }

    }
}
