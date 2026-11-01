package com.first_springboot.demo.dto;

import com.first_springboot.demo.model.Account;
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

public class RolesDto {



   private Long id;

 private String roleName;


}
