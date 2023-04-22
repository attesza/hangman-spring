package com.attesza.hangman.game.mapper;

import com.attesza.hangman.game.user.User;
import com.attesza.hangman.game.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(config = com.gallows.demo.MappingConfig.class)
public interface UserMapper {
    UserDto usertoUserDto(User user);
}
