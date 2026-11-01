package com.first_springboot.demo.mapper;

import com.first_springboot.demo.dto.AccountDto;
import com.first_springboot.demo.dto.RolesDto;
import com.first_springboot.demo.model.Account;
import com.first_springboot.demo.model.Roles;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface RolesMapper {


  Roles toEntity(RolesDto rolesDto);

  RolesDto toDto(Roles roles);

  List<Roles> toEntityList(List<RolesDto> rolesDtos);

  List<RolesDto> toDtoList(List<Roles> roles);

}
