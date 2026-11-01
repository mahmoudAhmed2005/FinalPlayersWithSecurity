package com.first_springboot.demo.repo;

import com.first_springboot.demo.model.Player;
import com.first_springboot.demo.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolesRepo extends JpaRepository<Roles,Long> {


}
