package com.attesza.hangman.game.repository;

import com.attesza.hangman.game.model.GameHighScore;
import com.attesza.hangman.game.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameHighScoreRepository extends JpaRepository<GameHighScore, Integer> {

    @Query("from GameHighScore order by score desc limit 10 ")
    List<GameHighScore> findTop();


    @Modifying
    @Query("UPDATE GameHighScore SET score=score+1")

    void addPoint(User user);

}
