package com.example.finish.service;

import com.example.finish.model.Game;

import java.util.List;

public interface GameService {
    void saveGame(Game game);

    List<Game> findAllGames();

    Game findGameById(int id);

    void deleteGameById(int id);
}
