package com.first_springboot.demo.mapper;

import com.first_springboot.demo.controller.vm.PlayerVM;
import com.first_springboot.demo.dto.PlayerDto;
import com.first_springboot.demo.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface PlayerMapper {

    @Mapping(source = "ref_num",target = "id")
  Player toEntity(PlayerDto playerDto);

    @Mapping(source = "id",target = "ref_num")
    @Mapping(target = "salary",ignore = true)
  PlayerDto toDto(Player player);

  List<Player>  toEntityList(List<PlayerDto> playerDtos);
  List<PlayerDto>   toDtoList(List<Player>players);
   PlayerVM toVM(Player player);
}
