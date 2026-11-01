package com.first_springboot.demo.repo;

import com.first_springboot.demo.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Long> {

  //extractName
  //nativeQuery = true    based on db
  //nativeQuery = false    based on model

 // @Query(value = "SELECT * FROM PLAYER WHERE NAME =  : name ",nativeQuery = true)

//  @Query(value = "SELECT player FROM PLAYER player WHERE player . name ",nativeQuery = false)
//
// Optional<Player>extractName(String name);


                       //or
  //findByName

  Optional<Player> findByName(String name);
  List<Player> findByNameContainingIgnoreCase(String name);
}
