package com.example.finish.service;

import com.example.finish.model.Game;
import com.example.finish.repo.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    private GameRepository gameRepository;

    @Override
    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    @Override
    public List<Game> findAllGames() {
        return (List<Game>) gameRepository.findAll();
    }

    @Override
    public Game findGameById(int id) {
        return gameRepository.findOne(id);
    }

    @Override
    public void deleteGameById(int id) {
        gameRepository.delete(id);
    }
}
