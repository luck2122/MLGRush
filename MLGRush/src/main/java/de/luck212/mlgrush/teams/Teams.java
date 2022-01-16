package de.luck212.mlgrush.teams;

import org.bukkit.ChatColor;

public enum Teams {

    Team1("Team-Rot", ChatColor.RED),
    Team2("Team-Blau", ChatColor.BLUE);

    private String name;
    private ChatColor chatColor;

    private Teams(String name, ChatColor color){
        this.chatColor = color;
        this.name = name;
    }

    public ChatColor getChatColor() {
        return chatColor;
    }

    public String getName() {
        return name;
    }
}