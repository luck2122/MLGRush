package de.luck212.mlgrush.main;

import de.luck212.mlgrush.comamnd.GiveMLGInventoryCommand;
import de.luck212.mlgrush.comamnd.SetTeamMemberCommand;
import de.luck212.mlgrush.comamnd.SpawnCommand;
import de.luck212.mlgrush.listener.BlockPlacedListener;
import de.luck212.mlgrush.listener.HeightListener;
import de.luck212.mlgrush.listener.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    private ArrayList<Player> players;
    private ArrayList<Block> blocksPlaced;

    @Override
    public void onEnable() {
        blocksPlaced = new ArrayList<Block>();
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new PlayerJoinListener(this), this);
        pluginManager.registerEvents(new HeightListener(this), this);
        pluginManager.registerEvents(new BlockPlacedListener(this), this);

        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("setinv").setExecutor(new GiveMLGInventoryCommand(this));
        getCommand("teamset").setExecutor(new SetTeamMemberCommand(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public ArrayList<Block> getBlocksPlaced() {
        return blocksPlaced;
    }

    public void setBlocksPlaced(ArrayList<Block> blocksPlaced) {
        this.blocksPlaced = blocksPlaced;
    }
}
