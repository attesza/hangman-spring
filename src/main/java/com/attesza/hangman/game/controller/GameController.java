package com.attesza.hangman.game.controller;

import com.attesza.hangman.game.dto.WordDto;
import com.attesza.hangman.game.mapper.GameMapper;
import com.attesza.hangman.game.repository.GameRepository;
import com.attesza.hangman.game.service.GameService;
import com.attesza.hangman.game.service.UserService;
import com.attesza.hangman.game.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class GameController {

    private GameMapper gameMapper;
    private GameService gameService;

    private UserService userService;
    private GameRepository gameRepository;

    @Autowired
    public GameController(GameMapper gameMapper, GameService gameService, UserService userService, GameRepository gameRepository) {
        this.gameMapper = gameMapper;
        this.gameService = gameService;
        this.userService = userService;
        this.gameRepository = gameRepository;
    }

    @GetMapping("/getCurrentUser")
    public User getCurrentUser() {
        return userService.currentUser();
    }

}
