package com.attesza.hangman.game.service;

import com.attesza.hangman.game.dto.HighScoreDto;
import com.attesza.hangman.game.dto.NewGameDto;
import com.attesza.hangman.game.enums.GameStateEnum;
import com.attesza.hangman.game.exception.GameException;
import com.attesza.hangman.game.model.Game;
import com.attesza.hangman.game.model.GameHighScore;
import com.attesza.hangman.game.model.Word;
import com.attesza.hangman.game.repository.GameHighScoreRepository;
import com.attesza.hangman.game.repository.GameRepository;
import com.attesza.hangman.game.repository.WordsRepository;
import com.attesza.hangman.game.service.IServices.IGameServices;
import com.attesza.hangman.game.user.User;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Transactional
@Log4j2
public class GameService implements IGameServices {
    private final GameRepository gameRepository;
    private final WordsRepository wordsRepository;

    private final GameHighScoreRepository gameHighScoreRepository;
    private final UserService userService;

    @Autowired
    public GameService(GameRepository gameRepository, WordsRepository wordsRepository, GameHighScoreRepository gameHighScoreRepository, UserService userService) {
        this.gameRepository = gameRepository;
        this.wordsRepository = wordsRepository;
        this.gameHighScoreRepository = gameHighScoreRepository;
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
            default -> {
                throw new GameException("Unsupported game level");
            }
        }
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
            log.info("words: " + word);
            String replacedWord = word.getWord().replaceAll(".", "*");
            Game game = new Game(replacedWord, 0, word, null, userService.currentUser(), GameStateEnum.ACTIVE);
            log.info("replacedWord: " + word.getWord());
            log.info("replacedWord: " + replacedWord);
            return gameRepository.save(game);
        } else {
            throw new GameException("Word is not exist");
        }


    }

    @Override
    public Game continueGame() {
        return gameRepository.findByUserAndGameState(userService.currentUser(), GameStateEnum.ACTIVE).orElseThrow(() -> new GameException("Game does not exist"));
    }

    @Override
    public List<HighScoreDto> getTopList() {
        List<GameHighScore> game = gameHighScoreRepository.findTop();
        List<HighScoreDto> highScore = game.stream().map(it -> {
            return new HighScoreDto(it.getUser().getFirstname() + " " + it.getUser().getLastname(), it.getScore());
        }).collect(Collectors.toList());
        if (userService.isLoggedIn()) {
            User user = userService.currentUser();
            if (game.stream().anyMatch(gameHighScore -> Objects.equals(gameHighScore.getUser().getId(), user.getId()))) {
                return highScore;
            } else {
                gameHighScoreRepository.findById(user.getId()).map(gameHighScore -> new HighScoreDto(gameHighScore.getUser()
                        .getFirstname() + " " + gameHighScore.getUser().getLastname(), gameHighScore.getScore())).ifPresent(highScore::add);
            }
        }
        return highScore;

    }

    @Override
    public void stopGame() {
        Game gameEntity = gameRepository.findByUserAndGameState(userService.currentUser(), GameStateEnum.ACTIVE).orElseThrow(() -> new GameException("Game does not exist"));
        gameEntity.setGameState(GameStateEnum.DONE);
        gameRepository.save(gameEntity);
    }

    @Override
    public Game tryChar(Character character) {


        Game game = gameRepository.findByUserAndGameState(userService.currentUser(), GameStateEnum.ACTIVE).orElseThrow(() -> new GameException("Game does not exist"));
        String stringBuilder;

        if (game.getTriedCharacter() != null) {
            stringBuilder = game.getTriedCharacter() +
                    character.toString();
        } else {
            stringBuilder = character.toString();
        }
        game.setTriedCharacter(stringBuilder);
        if (game.getActualWord().contains(character.toString())) {
            throw new GameException("This character is already used");
        }

        String originalWord = game.getOriginalWord().getWord();
        List<Integer> indexes = IntStream.range(0, originalWord.length())
                .filter(i -> originalWord.charAt(i) == character).boxed()
                .toList();
        log.info("indexes: " + indexes);
        if (indexes.isEmpty()) {
            game.setWrongCounter(game.getWrongCounter() + 1);
        }

        char[] chars = game.getActualWord().toCharArray();
        log.info("chars: " + Arrays.toString(chars));
        indexes.forEach(it -> {
            chars[it] = character;
        });
        game.setActualWord(toStringConvert(chars));
        if (!game.getActualWord().contains("*")) {
            if (gameHighScoreRepository.existsById(game.getUser().getId())) {
                gameHighScoreRepository.addPoint(game.getUser());
            } else {
                gameHighScoreRepository.save(new GameHighScore(game.getUser(), 1));
            }
            game.setGameState(GameStateEnum.SUCCESS);
        } else if (game.getWrongCounter() == 6) {
            game.setGameState(GameStateEnum.DONE);
        }
        return gameRepository.save(game);

    }

    public static String toStringConvert(char[] a) {
        return new String(a);
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
