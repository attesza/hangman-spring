package com.attesza.hangman.game.dto;

public class GameDto {
    private Integer wrongCounter;

    private String actualWord;

    public Integer getWrongCounter() {
        return wrongCounter;
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
