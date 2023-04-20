package com.attesza.hangman.game.mapper;

import com.attesza.hangman.game.dto.WordDto;
import com.attesza.hangman.game.model.Word;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = com.gallows.demo.MappingConfig.class)
public interface WordsMapper {

    WordDto wordtoWordDto(Word words);

    List<WordDto> wordsListToDto(List<Word> words);
}
