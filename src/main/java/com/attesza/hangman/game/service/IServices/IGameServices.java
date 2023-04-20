package com.attesza.hangman.game.service.IServices;

import com.attesza.hangman.game.dto.NewGameDto;
import com.attesza.hangman.game.model.Game;

public interface IGameServices {
    Game createNewGame(NewGameDto newGameDto);

    Game continueGame();

    void stopGame();

    Game tryChar(Character character);
}
