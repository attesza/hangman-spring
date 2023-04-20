package com.attesza.hangman.game.dto;



public class WordsDto {
    private Long id;
    private String word;

    public WordsDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
