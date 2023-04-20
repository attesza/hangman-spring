package com.attesza.hangman.game.controller;

import com.attesza.hangman.game.dto.WordDto;
import com.attesza.hangman.game.mapper.WordsMapper;
import com.attesza.hangman.game.repository.WordsRepository;
import com.attesza.hangman.game.service.WordsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class WordsController {
    private WordsMapper wordsMapper;
    private WordsService wordsService;
    private WordsRepository wordRepository;

    @Autowired
    public WordsController(WordsMapper wordsMapper, WordsService wordsService, WordsRepository wordRepository) {
        this.wordsMapper = wordsMapper;
        this.wordsService = wordsService;
        this.wordRepository = wordRepository;
    }

    @GetMapping("/words")
    public List<WordDto> listAllWords() {
        return wordsMapper.wordsListToDto(wordsService.findAllWords());
    }

    @PostMapping("/word")
    public WordDto addWord(@RequestBody WordDto wordsDto){
        return wordsMapper.wordtoWordDto(wordsService.addWords(wordsDto));
    }
}
