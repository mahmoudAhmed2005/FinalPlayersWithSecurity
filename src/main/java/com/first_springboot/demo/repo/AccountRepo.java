package com.first_springboot.demo.repo;

import com.first_springboot.demo.model.Account;
import com.first_springboot.demo.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {

    Optional<Account>findByEmail(String email);

}
