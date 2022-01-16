package de.luck212.mlgrush.listener;

import de.luck212.mlgrush.main.Main;
import de.luck212.mlgrush.util.ConfigLocationUtil;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerJoinListener implements Listener {

    Main plugin;
    ConfigLocationUtil configLocationUtil;

    public PlayerJoinListener(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        plugin.addPlayer(player);
        event.setJoinMessage("§aDer Spieler §4" + player.getName() + " §ahat den Server betreten");
        if(plugin.getPlayers().size() == 1){
            configLocationUtil = new ConfigLocationUtil(plugin, "1");
            player.teleport(configLocationUtil.loadLocation());
        }else{
            configLocationUtil = new ConfigLocationUtil(plugin, "2");
            player.teleport(configLocationUtil.loadLocation());
        }
    }

    @EventHandler
    public void handleFoodLevelChange(FoodLevelChangeEvent event){
        event.setCancelled(true);
    }
}