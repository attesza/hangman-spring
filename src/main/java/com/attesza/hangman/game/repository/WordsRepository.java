package com.attesza.hangman.game.repository;

import com.attesza.hangman.game.model.Words;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRepository extends JpaRepository<Words, Integer> {
}
