package de.luck212.mlgrush.listener;

import de.luck212.mlgrush.main.Main;
import de.luck212.mlgrush.mlginv.MLGInventory;
import de.luck212.mlgrush.teams.TeamManager;
import de.luck212.mlgrush.teams.Teams;
import de.luck212.mlgrush.util.ConfigLocationUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class HeightListener implements Listener {

    Main plugin;

    public HeightListener(Main plugin){
        this.plugin = plugin;
    }

    //TODO Noch so machen das Spieler zurück an seinen Platz teleportiert wird und das inv resettet wird
    @EventHandler
    public void onHeightchange(PlayerMoveEvent event){
        if(event.getFrom().getY() <= 20){
            Player player = event.getPlayer();
            MLGInventory inventory = new MLGInventory(player);
            inventory.clearInventory();
            inventory.fillInventory();

            for(Block block : plugin.getBlocksPlaced()){
                block.setType(Material.AIR);
                plugin.getBlocksPlaced().remove(block);
            }

            for(Player current : Bukkit.getOnlinePlayers()){
                TeamManager teamManager = new TeamManager();
                Teams currentTeams = teamManager.getTeamRole(current);
                if(currentTeams != null){
                    try {
                        if (currentTeams == Teams.Team1)
                            player.teleport(new ConfigLocationUtil(plugin, "1").loadLocation());
                        else if (currentTeams == Teams.Team2)
                            player.teleport(new ConfigLocationUtil(plugin, "2").loadLocation());
                    }catch (Exception e){
                        Bukkit.getConsoleSender().sendMessage("Die Spawns wurden noch nicht definiert.");
                    }
                }
            }
        }
    }
}