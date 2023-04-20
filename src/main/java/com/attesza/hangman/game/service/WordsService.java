package com.attesza.hangman.game.service;

import com.attesza.hangman.game.dto.WordsDto;
import com.attesza.hangman.game.model.Words;
import com.attesza.hangman.game.repository.WordsRepository;
import com.attesza.hangman.game.service.IServices.IWordsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class WordsService implements IWordsServices {
    private final WordsRepository wordRepository;


    @Override
    public Words addWords(WordsDto wordsDto) {
        Words words = new Words(wordsDto.getWord());
        return wordRepository.save(words);
    }

    @Override
    public List<Words> findAllWords() {
        return wordRepository.findAll();
    }
}
