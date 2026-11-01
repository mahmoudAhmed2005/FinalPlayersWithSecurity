package com.first_springboot.demo.mapper;

import com.first_springboot.demo.controller.vm.PlayerVM;
import com.first_springboot.demo.dto.AccountDto;
import com.first_springboot.demo.dto.PlayerDto;
import com.first_springboot.demo.model.Account;
import com.first_springboot.demo.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface AccountMapper {


  Account toEntity(AccountDto accountDto);


  AccountDto toDto(Account account);

  List<Account>  toEntityList(List<AccountDto> accountDtos);

  List<AccountDto>   toDtoList(List<Account>accounts);

}
