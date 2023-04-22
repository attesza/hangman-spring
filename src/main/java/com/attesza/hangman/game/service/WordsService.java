package com.attesza.hangman.game.service;

import com.attesza.hangman.game.dto.WordDto;
import com.attesza.hangman.game.exception.GameException;
import com.attesza.hangman.game.model.Word;
import com.attesza.hangman.game.repository.WordsRepository;
import com.attesza.hangman.game.service.IServices.IWordsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Validated
public class WordsService implements IWordsServices {
    private final WordsRepository wordRepository;


    @Override
    public Word addWords(WordDto wordDto) {
        boolean exist = wordRepository.existsByWord(wordDto.getWord());
        if (!exist) {
            Word word = new Word(wordDto.getWord());
            return wordRepository.save(word);
        } else {
            throw new GameException("Word exists");
        }
    }

    @Override
    public List<Word> findAllWords() {
        return wordRepository.findAll();
    }
}
