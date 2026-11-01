package com.first_springboot.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Roles {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)



   private Long id;

 private String roleName;

    @ManyToMany(mappedBy = "roles")
 private List<Account> account;

}
