package de.luck212.mlgrush.teams;

import de.luck212.mlgrush.main.Main;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class TeamManager {

    private HashMap<String, Teams> playerTeams;
    private Player player;
    private String team;

    public TeamManager(Player player, String team){
        this.player = player;
        this.team = team;
        playerTeams = new HashMap<>();
    }

    public TeamManager(){

    }

    public void setTeamMembers(){
        if(team.equalsIgnoreCase("1"))
            playerTeams.put(player.getName(), Teams.Team1);
        else if(team.equalsIgnoreCase("2"))
            playerTeams.put(player.getName(), Teams.Team2);
    }

    public Teams getTeamRole(Player player) {
        return playerTeams.get(player.getName());
    }
}