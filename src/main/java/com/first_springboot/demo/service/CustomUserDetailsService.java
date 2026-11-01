package com.first_springboot.demo.service;

import com.first_springboot.demo.dto.AccountDto;
import com.first_springboot.demo.helper.CustomUserDetails;
import com.first_springboot.demo.model.Account;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class CustomUserDetailsService implements UserDetailsService {

private AccountService accountService;
@Autowired
    public CustomUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {

          AccountDto accountDto = accountService.getByEmail(username);
          return new CustomUserDetails(accountDto);


        } catch (SystemException e) {
            throw new RuntimeException(e);
        }
    }
}
