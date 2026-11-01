package com.first_springboot.demo.service;

import com.first_springboot.demo.controller.vm.PlayerVM;
import com.first_springboot.demo.dto.PlayerDto;

import jakarta.transaction.SystemException;

import java.util.List;

public interface PlayerService {


    PlayerDto savePlayer(PlayerDto playerDto) throws SystemException;

    PlayerDto updatePlayer(PlayerDto playerDto) throws SystemException;

    List<PlayerDto> getAllPlayers();

    void removePlayer(Long id);

    PlayerDto getPlayerById(Long id) throws SystemException;

    PlayerDto getPlayerByName(String name)throws SystemException ;

    List<PlayerDto>searchName(String name)throws SystemException;
}
