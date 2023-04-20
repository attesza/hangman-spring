package com.attesza.hangman.game.repository;

import com.attesza.hangman.game.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WordsRepository extends JpaRepository<Word, Integer> {
//    @Query(value = "SELECT * FROM Words w WHERE w.word =>3 ", nativeQuery = true)

    @Query("SELECT w FROM Word w WHERE LENGTH( w.word) < 9")
    List<Word> findAllByWordLevelEasy();
    @Query("SELECT w FROM Word w WHERE LENGTH( w.word) > 8 AND LENGTH(w.word)< 12")
    List<Word> findAllByWordLevelMedium();
    @Query("SELECT w FROM Word w WHERE LENGTH( w.word) > 11 ")
    List<Word> findAllByWordLevelHard();
}
