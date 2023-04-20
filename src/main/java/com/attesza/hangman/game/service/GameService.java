package com.attesza.hangman.game.service;

import com.attesza.hangman.game.dto.NewGameDto;
import com.attesza.hangman.game.enums.GameStateEnum;
import com.attesza.hangman.game.exception.GameException;
import com.attesza.hangman.game.model.Game;
import com.attesza.hangman.game.model.Word;
import com.attesza.hangman.game.repository.GameRepository;
import com.attesza.hangman.game.repository.WordsRepository;
import com.attesza.hangman.game.service.IServices.IGameServices;
import com.zaxxer.hikari.util.FastList;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Log4j2
public class GameService implements IGameServices {
    private final GameRepository gameRepository;
    private final WordsRepository wordsRepository;

    private final UserService userService;

    @Autowired
    public GameService(GameRepository gameRepository, WordsRepository wordsRepository, UserService userService) {
        this.gameRepository = gameRepository;
        this.wordsRepository = wordsRepository;
        this.userService = userService;
    }

    public List<Word> allByLevel(Integer level) {
        switch (level) {
            case 1 -> {
                return wordsRepository.findAllByWordLevelEasy();
            }
            case 2 -> {
                return wordsRepository.findAllByWordLevelMedium();
            }
            case 3 -> {
                return wordsRepository.findAllByWordLevelHard();
            }

        }
        return null;
    }

    @Override
    public Game createNewGame(NewGameDto newGameDto) {
        gameRepository.findByUserAndGameState(userService.currentUser(), GameStateEnum.ACTIVE).ifPresent(it -> {
            it.setGameState(GameStateEnum.DONE);
            gameRepository.save(it);
        });
        List<Word> allByLevel = allByLevel(newGameDto.getLevel());

        if (!allByLevel.isEmpty()) {
            Word word = allByLevel.get(getRandomNumber(0, allByLevel.size() - 1));
            log.info("words: "+ word);
            String replacedWord = word.getWord().replaceAll(".", "*");
            Game game = new Game(replacedWord, 0, word, userService.currentUser(), GameStateEnum.ACTIVE);
            log.info("replacedWord: "+ word.getWord());
            log.info("replacedWord: "+ replacedWord);
            return gameRepository.save(game);
        } else {
            throw new GameException("Word is not exist");
        }


    }

    @Override
    public Game continueGame() {
        return null;
    }

    @Override
    public void stopGame() {

    }

    @Override
    public Game tryChar(Character character) {
        return null;
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
