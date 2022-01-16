package de.luck212.mlgrush.comamnd;

import de.luck212.mlgrush.main.Main;
import de.luck212.mlgrush.mlginv.MLGInventory;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveMLGInventoryCommand implements CommandExecutor {

    Main plugin;

    public GiveMLGInventoryCommand(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;

        for(Player current : Bukkit.getOnlinePlayers()){
            MLGInventory inventory = new MLGInventory(current);
            inventory.fillInventory();
        }

        return false;
    }
}

