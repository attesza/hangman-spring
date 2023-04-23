package com.attesza.hangman.game.repository;

import com.attesza.hangman.game.model.Word;
import com.attesza.hangman.game.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WordsRepository extends JpaRepository<Word, Integer> {
//    @Query(value = "SELECT * FROM Words w WHERE w.word =>3 ", nativeQuery = true)

    boolean existsByWord(String word);

    @Query("SELECT w FROM Word w WHERE LENGTH( w.word) < 9 AND not exists (select game.originalWord.id from Game game where game.user = :user and game.originalWord=w)")
    List<Word> findAllByWordLevelEasy(User user);
    @Query("SELECT w FROM Word w WHERE LENGTH( w.word) > 8 AND LENGTH(w.word)< 12 AND not exists (select game.originalWord.id from Game game where game.user = :user and game.originalWord=w)")
    List<Word> findAllByWordLevelMedium(User user);
    @Query("SELECT w FROM Word w WHERE LENGTH( w.word) > 11 AND not exists (select game.originalWord.id from Game game where game.user = :user and game.originalWord=w)")
    List<Word> findAllByWordLevelHard(User user);
}
