package com.first_springboot.demo.service.impl;

import com.first_springboot.demo.controller.vm.PlayerVM;
import com.first_springboot.demo.dto.PlayerDto;

import com.first_springboot.demo.mapper.PlayerMapper;
import com.first_springboot.demo.model.Player;
import com.first_springboot.demo.repo.PlayerRepo;
import com.first_springboot.demo.service.PlayerService;
import jakarta.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

   /* private ModelMapper modelMapper;*/

    private PlayerMapper playerMapper;

  private PlayerRepo playerRepo;

    @Autowired
    public PlayerServiceImpl(PlayerRepo playerRepo, PlayerMapper playerMapper /*, ModelMapper modelMapper*/){

        this.playerRepo=playerRepo;
        this.playerMapper=playerMapper;
       /* this.modelMapper=modelMapper*/;
    }


    @Override
    public PlayerDto savePlayer(PlayerDto playerDto) throws SystemException {

        //this check for id should be null
        if(Objects.nonNull(playerDto.getRef_num())){
            throw  new SystemException("player.id.isNull");
        }

        //this check for salary should be found
        if(Objects.isNull(playerDto.getSalary())){
            throw  new SystemException("salary mast be found");
        }

        //this check for number should be found
        if(Objects.isNull(playerDto.getNumber())){
            throw  new SystemException("number mast be found");
        }

         //this check for name should be found
        if(Objects.isNull(playerDto.getName())){
            throw  new SystemException("name mast be found");
        }





        //this check for name not be doublicated name

        Optional<Player> playerOptional = playerRepo.findByName(playerDto.getName());

        if (playerOptional.isPresent()){
            throw new SystemException("userName exsist by name" + playerDto.getName());
        }

        Player player = playerMapper.toEntity(playerDto);

        return toDto(playerRepo.save(player));
    }


    @Override
    public PlayerDto updatePlayer(PlayerDto playerDto) throws SystemException {
        //this check for id should be found
        if(Objects.isNull(playerDto.getRef_num())){
            throw  new SystemException("player.id.notNull");
        }


        Optional<Player> playerOptional = playerRepo.findById(playerDto.getRef_num());
        if (playerOptional.isEmpty()){
            throw  new SystemException("player not found " + playerDto.getRef_num());
        }

        Player player = playerMapper.toEntity(playerDto);

        if (playerOptional.get().getName().equals(playerDto.getName())){
             playerRepo.save(player);

            return playerDto ;
        }

        playerOptional = playerRepo.findByName(playerDto.getName());
        if (playerOptional.isPresent()){
            throw new SystemException("userName exsist by name" + playerDto.getName());
        }


        playerRepo.save(player);
        return playerDto;
    }


    @Override
    public List<PlayerDto> getAllPlayers() {

        //toDto

// List<PlayerDto> playerDtos = playerRepo.findAll().stream().map(player ->
//                new PlayerDto().toDto(player)).collect(Collectors.toList());
//
//        long count = playerRepo.count();
//        playerDtos.stream().forEach(playerDto -> {
//            playerDto.setDetails(playerDto.getName()+""+playerDto.getId());
//            playerDto.setCount(count);
//
//        });
//
//        return playerDtos;



        //toVM


//       return playerRepo.findAll().stream().map(player ->
//                new PlayerVM(player.getId(),player.getName())).collect(Collectors.toList());


        //toModelMapeer

//        return playerRepo.findAll().stream().map(player ->
//                playerMapper.toDto(player)).collect(Collectors.toList());


        //toMapper getCont and ditals

//        List<PlayerDto>playerDtos=playerMapper.toDtoList(playerRepo.findAll());
//        long count=playerRepo.count();
//        playerDtos.stream().forEach(playerDto -> {
//            playerDto.setDetails(playerDto.getName() + " " + playerDto.getRef_num());
//            playerDto.setCount(count);
//        } );
//
//        return playerDtos;

       return playerMapper.toDtoList(playerRepo.findAll());





//        players.stream().forEach(player -> player.setDetails(player.getName() +  player.getId()));
//
//        return players;
    }

    @Override
    public void removePlayer(Long id) {
        playerRepo.deleteById(id);
    }

    @Override
    public PlayerDto getPlayerById(Long id) throws SystemException {
//       Optional<Player> player= playerRepo.findById(id);
//
//        return player.get();

        //=====
   Player player= playerRepo.findById(id).get();

   return toDto(player);

    }

    @Override
    public PlayerDto getPlayerByName(String name) throws SystemException  {

        Player player= playerRepo.findByName(name).get();
        return toDto(player);

    }

    @Override
    public List<PlayerDto> searchName(String name) throws SystemException {
//       return playerRepo.findByNameContainingIgnoreCase(name).get().stream().map(player ->
//               toDto(player)).collect(Collectors.toList());

        return playerMapper.toDtoList(playerRepo.findByNameContainingIgnoreCase(name));

    }




    public PlayerDto toDto(Player player){
        return playerMapper.toDto(player);


    }


}
