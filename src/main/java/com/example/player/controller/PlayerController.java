package com.example.player.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.player.model.Player;
import com.example.player.service.PlayerJpaService;

// Write your code here

@RestController
public class PlayerController {
    @Autowired
    public PlayerJpaService PJS;

    @GetMapping("/players")
    public ArrayList<Player> allPlayer() {
        return PJS.allPlayer();
    }

    @GetMapping("/players/{playerId}")
    public Player eachPlayer(@PathVariable("playerId") int playerId) {
        return PJS.eachPlayer(playerId);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player plays) {
        return PJS.addPlayer(plays);
    }

    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId, @RequestBody Player plays) {
        return PJS.updatePlayer(playerId, plays);
    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId){
        PJS.deletePlayer(playerId);
    }
}
