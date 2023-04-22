package com.attesza.hangman.game.controller;

import com.attesza.hangman.game.mapper.UserMapper;
import com.attesza.hangman.game.service.UserService;
import com.attesza.hangman.game.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private UserMapper userMapper;

    private UserService userService;

    @Autowired
    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping("/getCurrentUser")
    public UserDto getCurrentUser() {
        return userMapper.usertoUserDto(userService.currentUser());
    }
}
