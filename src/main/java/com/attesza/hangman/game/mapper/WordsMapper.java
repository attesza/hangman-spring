package com.attesza.hangman.game.mapper;

import com.attesza.hangman.game.dto.WordsDto;
import com.attesza.hangman.game.model.Words;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(config = com.gallows.demo.MappingConfig.class)
public interface WordsMapper {

    WordsDto wordstoWordsDto(Words words);

    List<WordsDto> wordsListToDto(List<Words> words);
}
