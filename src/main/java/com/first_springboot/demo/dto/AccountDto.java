package com.first_springboot.demo.dto;

import com.first_springboot.demo.model.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AccountDto {








        private  Long id;
        private String email;
        private   String password;


        private List<RolesDto> roles ;


    }

