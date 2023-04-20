package com.attesza.hangman.game.service;

import com.attesza.hangman.game.enums.GameStateEnum;
import com.attesza.hangman.game.model.Game;
import com.attesza.hangman.game.model.Word;
import com.attesza.hangman.game.repository.GameRepository;
import com.attesza.hangman.game.repository.WordsRepository;
import com.attesza.hangman.game.service.IServices.IGameServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
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

    @Override
    public Game createNewGame(Integer level) {
        //todo folyt
//        gameRepository.findByUserAndGameState(userService.currentUser(), GameStateEnum.ACTIVE).ifPresent(it -> {
//            it.setGameState(GameStateEnum.DONE);
//            gameRepository.save(it);
//        });
//        List<Word> allByLevel = wordsRepository.findAllByWordLevel(level);
//        if (!allByLevel.isEmpty()) {
//            WordEntity wordEntity = allByLevel.get(getRandomNumber(0, allByLevel.size() - 1));
//            String replacedWord = wordEntity.getText().replaceAll(".", "*");
//            return gameRepository.save(new GameEntity(replacedWord, 0, wordEntity, userService.currentUser(), GameStateEnum.ACTIVE));
//        } else {
//            throw new BasicGallowsException("Word is not exist");
//        }
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
