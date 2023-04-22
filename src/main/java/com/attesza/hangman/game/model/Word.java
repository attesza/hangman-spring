package com.attesza.hangman.game.model;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "words")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;

    protected Word() {

    }

    public Word(@NotNull String word) {
        this.word = word;
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
