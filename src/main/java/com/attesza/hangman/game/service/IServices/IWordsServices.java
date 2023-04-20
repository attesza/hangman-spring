package com.attesza.hangman.game.service.IServices;

import com.attesza.hangman.game.dto.WordsDto;
import com.attesza.hangman.game.model.Words;

import java.util.List;

public interface IWordsServices {
    Words addWords(WordsDto wordsDto);
    List<Words> findAllWords();
}
