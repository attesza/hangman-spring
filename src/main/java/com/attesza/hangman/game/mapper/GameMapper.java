package com.attesza.hangman.game.mapper;

import com.attesza.hangman.game.dto.GameDto;
import com.attesza.hangman.game.model.Game;
import org.mapstruct.Mapper;

@Mapper(config = com.gallows.demo.MappingConfig.class)
public interface GameMapper {
    GameDto toDto(Game game);
    Game gameToEntity(GameDto gameDto);
}