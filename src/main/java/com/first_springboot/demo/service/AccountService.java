package com.first_springboot.demo.service;

import com.first_springboot.demo.dto.AccountDto;
import jakarta.transaction.SystemException;

public interface AccountService {

    AccountDto getByEmail(String email) throws SystemException;
}
