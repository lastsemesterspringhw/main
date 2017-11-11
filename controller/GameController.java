package com.example.finish.controller;

import com.example.finish.model.Administrator;
import com.example.finish.model.Game;
import com.example.finish.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public String hello(){
        return "first";
    }

    @GetMapping("/controller/add")
    public String renderAdd(Model model){

        List<Game> games = gameService.findAllGames();
        model.addAttribute("games", games);
        model.addAttribute("game", new Game());

        return "add";
    }

    @PostMapping("/controller/add")
    public String add(@ModelAttribute("game") Game game){
        gameService.saveGame(game);
        return "redirect:/controller/add";
    }

    @GetMapping("/controller/showAll")
    public String showAllAdmins(Model model){
        List<Game> games = gameService.findAllGames();
        model.addAttribute("games", games);
        return "list";
    }


    @RequestMapping(value = "/controller/edit/{id}")
    public String editStudent(@PathVariable("id") int id, Model model){

        List<Game> games = gameService.findAllGames();
        model.addAttribute("games", games);



        Game game = gameService.findGameById(id);
        model.addAttribute("game", game);

        return "add";

    }

    @RequestMapping(value = "/controller/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        gameService.deleteGameById(id);
        return "deleted";
    }


}
