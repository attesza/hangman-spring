package com.attesza.hangman.game.repository;

import com.attesza.hangman.game.enums.GameStateEnum;
import com.attesza.hangman.game.model.Game;
import com.attesza.hangman.game.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    Optional<Game> findByUserAndGameState(User user, GameStateEnum stateEnum);
}
