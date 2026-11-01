package com.first_springboot.demo.service.impl;

import com.first_springboot.demo.dto.AccountDto;
import com.first_springboot.demo.mapper.AccountMapper;
import com.first_springboot.demo.model.Account;
import com.first_springboot.demo.repo.AccountRepo;
import com.first_springboot.demo.service.AccountService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepo;
    private AccountMapper accountMapper;


@Autowired
    public AccountServiceImpl(AccountRepo accountRepo,AccountMapper accountMapper) {
        this.accountRepo = accountRepo;
    this.accountMapper = accountMapper;
    }

    @Override
    public AccountDto getByEmail(String email) throws SystemException {

   Optional<Account>accountOptional= accountRepo.findByEmail(email);

   if (accountOptional.isEmpty()){
       throw new SystemException("account.not.exsist");
   }


        return accountMapper.toDto(accountOptional.get());
    }
}
