// Write your code here
package com.example.player.repository;

import com.example.player.model.Player;
import java.util.*;

public interface PlayerRepository {
    ArrayList<Player> allPlayer();

    Player eachPlayer(int playerId);

    Player addPlayer(Player plays);

    Player updatePlayer(int playerId, Player plays);

    void deletePlayer(int playerId);

}