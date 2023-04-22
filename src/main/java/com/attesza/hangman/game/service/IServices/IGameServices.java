package com.attesza.hangman.game.service.IServices;

import com.attesza.hangman.game.dto.HighScoreDto;
import com.attesza.hangman.game.dto.NewGameDto;
import com.attesza.hangman.game.model.Game;

import java.util.List;


public interface IGameServices {
    Game createNewGame(NewGameDto newGameDto);

    Game continueGame();

    List<HighScoreDto> getTopList();

    void stopGame();

    Game tryChar(Character character);
}
