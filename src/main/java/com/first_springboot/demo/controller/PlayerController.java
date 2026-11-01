package com.first_springboot.demo.controller;


import com.first_springboot.demo.controller.vm.PlayerVM;
import com.first_springboot.demo.dto.PlayerDto;

import com.first_springboot.demo.model.Player;
import com.first_springboot.demo.service.PlayerService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.security.authorization.AuthorityAuthorizationManager.hasAnyRole;


@RestController   // Controller use jason value

@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }





    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
public ResponseEntity<List<PlayerDto>>  getAllPlayers(){

        return ResponseEntity.ok(playerService.getAllPlayers()) ;
}


@PostMapping()

@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")

    public ResponseEntity<PlayerDto>  addPlayer(@RequestBody @Validated PlayerDto playerDto) throws SystemException, URISyntaxException {

      return ResponseEntity.created(new URI("/players")).body(playerService.savePlayer(playerDto)) ;
}


@PutMapping()

    public ResponseEntity<PlayerDto> updatePlayer(@RequestBody @Validated PlayerDto playerDto) throws SystemException {
        return ResponseEntity.ok(playerService.updatePlayer(playerDto))  ;
}


 //   http://localhost:8080/players?id=13
 /*@DeleteMapping("/players")
    public void deletePlayer(@RequestParam Long id){
     playerService.removePlayer(id);

 }*/


    //or

    //   http://localhost:8080/players/13
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deletePlayer(@PathVariable Long id){
     playerService.removePlayer(id);
     return ResponseEntity.noContent().build();

 }




 @GetMapping("/{id}")

    public ResponseEntity<PlayerDto>  getPlayerById(@PathVariable Long id) throws SystemException {
       return ResponseEntity.ok(playerService.getPlayerById(id)) ;
 }


 @GetMapping("/name/{name}")

    public ResponseEntity<PlayerDto> getPlayerByName(@PathVariable String name) throws SystemException {

        return ResponseEntity.ok(playerService.getPlayerByName(name)) ;

 }


    @GetMapping("/search/{name}")

    public ResponseEntity <List<PlayerDto>> searchName(@PathVariable String name) throws SystemException {

        return ResponseEntity.ok(playerService. searchName(name)) ;
}


}
