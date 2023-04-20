package com.attesza.hangman.game.service.IServices;

import com.attesza.hangman.game.dto.WordDto;
import com.attesza.hangman.game.model.Word;

import java.util.List;

public interface IWordsServices {
    Word addWords(WordDto wordsDto);
    List<Word> findAllWords();
}
