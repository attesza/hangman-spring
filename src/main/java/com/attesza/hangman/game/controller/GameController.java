package com.attesza.hangman.game.controller;

import com.attesza.hangman.game.dto.GameDto;
import com.attesza.hangman.game.dto.HighScoreDto;
import com.attesza.hangman.game.dto.NewGameDto;
import com.attesza.hangman.game.dto.WordDto;
import com.attesza.hangman.game.mapper.GameMapper;
import com.attesza.hangman.game.mapper.UserMapper;
import com.attesza.hangman.game.model.GameHighScore;
import com.attesza.hangman.game.repository.GameRepository;
import com.attesza.hangman.game.service.GameService;
import com.attesza.hangman.game.service.UserService;
import com.attesza.hangman.game.user.User;
import com.attesza.hangman.game.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class GameController {

    private GameMapper gameMapper;
    private GameService gameService;

    private GameRepository gameRepository;

    @Autowired
    public GameController(GameMapper gameMapper, GameService gameService,  GameRepository gameRepository) {
        this.gameMapper = gameMapper;
        this.gameService = gameService;
        this.gameRepository = gameRepository;
    }



    @PostMapping( "/newGame")
    public GameDto newGame(@RequestBody NewGameDto dto) {
        return gameMapper.toDto(gameService.createNewGame(dto));
    }

    @PostMapping("/stopGame")
    public void stopGame() {
        gameService.stopGame();
    }



    @PostMapping("/continueGame")
    public GameDto continueGame() {
        return gameMapper.toDto(gameService.continueGame());
    }

    @PostMapping("/tryChar")
    public GameDto attempt(@RequestParam(name = "char") Character character){
        return gameMapper.toDto(gameService.tryChar(character));
    }

    @GetMapping("/hasActiveGame")
    public boolean hasActiveGame(){
        return gameService.hasActive();
    }

    @GetMapping("/topTen")
    public List<HighScoreDto> topTenList(){
        return gameService.getTopList();
    }
}
