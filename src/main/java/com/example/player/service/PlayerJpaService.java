package com.example.player.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.player.model.Player;
import com.example.player.repository.PlayerRepository;
import com.example.player.repository.PlayerJpaRepository;

// Write your code here
@Service
public class PlayerJpaService implements PlayerRepository {
    @Autowired
    private PlayerJpaRepository pjr;

    @Override
    public ArrayList<Player> allPlayer() {
        List<Player> play = pjr.findAll();
        ArrayList<Player> allPlay = new ArrayList<>(play);
        return allPlay;
    }

    @Override
    public Player eachPlayer(int playerId) {
        try {
            Player player = pjr.findById(playerId).get();
            return player;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Player addPlayer(Player plays) {
        pjr.save(plays);
        return plays;
    }

    @Override
    public Player updatePlayer(int playerId, Player plays) {
        try {
            Player update = pjr.findById(playerId).get();

            if (plays.getPlayerName() != null) {
                update.setPlayerName(plays.getPlayerName());
            }
            if (plays.getJerseyNumber() >= 0) {
                update.setJerseyNumber(plays.getJerseyNumber());
            }
            if (plays.getRole() != null) {
                update.setRole(plays.getRole());
            }
            pjr.save(update);
            return update;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deletePlayer(int playerId){
        try{
            pjr.deleteById(playerId);
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}