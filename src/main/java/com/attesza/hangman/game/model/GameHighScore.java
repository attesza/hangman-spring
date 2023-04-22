package com.attesza.hangman.game.model;

import com.attesza.hangman.game.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "game_higscore")
public class GameHighScore {

    @Id
    @Column(name = "user_id")
    private int id;

    @MapsId("id")
    @ManyToOne
    private User user;
    private int score;

    protected GameHighScore() {
    }


    public User getUser() {
        return user;
    }

    public GameHighScore(User user, int score) {
        this.id = user.getId();
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
