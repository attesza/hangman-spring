package com.attesza.hangman.game.model;

import com.attesza.hangman.game.enums.GameStateEnum;
import com.attesza.hangman.game.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "actual_word")
    private String actualWord;

    @Column(name = "wrong_counter")
    private Integer wrongCounter;

    @ManyToOne
    @JoinColumn(name = "word_id")
    private Word originalWord;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "game_state")
    @Enumerated(value = EnumType.STRING)
    private GameStateEnum gameState;

    protected Game() {
    }

    public Game(String actualWord, Integer wrongCounter, Word originalWord, User user, GameStateEnum gameState) {
        this.actualWord = actualWord;
        this.wrongCounter = wrongCounter;
        this.originalWord = originalWord;
        this.user = user;
        this.gameState = gameState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActualWord() {
        return actualWord;
    }

    public void setActualWord(String actualWord) {
        this.actualWord = actualWord;
    }

    public Integer getWrongCounter() {
        return wrongCounter;
    }

    public void setWrongCounter(Integer wrongCounter) {
        this.wrongCounter = wrongCounter;
    }

    public Word getOriginalWord() {
        return originalWord;
    }

    public void setOriginalWord(Word originalWord) {
        this.originalWord = originalWord;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GameStateEnum getGameState() {
        return gameState;
    }

    public void setGameState(GameStateEnum gameState) {
        this.gameState = gameState;
    }
}
