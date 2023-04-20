package com.attesza.hangman.game.service.IServices;

import com.attesza.hangman.game.model.Game;

public interface IGameServices {
    Game createNewGame(Integer level);

    Game continueGame();

    void stopGame();

    Game tryChar(Character character);
}
