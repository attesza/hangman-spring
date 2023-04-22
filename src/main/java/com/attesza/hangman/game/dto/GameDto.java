package com.attesza.hangman.game.dto;

public class GameDto {
    private Integer wrongCounter;

    private String actualWord;
    private String triedCharacter;

    public Integer getWrongCounter() {
        return wrongCounter;
    }

    public String getTriedCharacter() {
        return triedCharacter;
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
