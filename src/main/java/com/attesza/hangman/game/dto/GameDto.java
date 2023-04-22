package com.attesza.hangman.game.dto;

import com.attesza.hangman.game.enums.GameStateEnum;

public class GameDto {
    private Integer wrongCounter;

    private String actualWord;
    private String triedCharacter;

    private GameStateEnum gameState;
    public Integer getWrongCounter() {
        return wrongCounter;
    }

    public String getTriedCharacter() {
        return triedCharacter;
    }

    public GameStateEnum getGameState() {
        return gameState;
    }

    public void setGameState(GameStateEnum gameState) {
        this.gameState = gameState;
    }

    public void setTriedCharacter(String triedCharacter) {
        this.triedCharacter = triedCharacter;
    }

    public void setWrongCounter(Integer wrongCounter) {
        this.wrongCounter = wrongCounter;
    }

    public String getActualWord() {
        return actualWord;
    }

    public void setActualWord(String actualWord) {
        this.actualWord = actualWord;
    }
}
