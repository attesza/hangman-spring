package com.attesza.hangman.game.dto;

public class HighScoreDto {

    private int score;
    private String name;

    public HighScoreDto(String name, int score) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
