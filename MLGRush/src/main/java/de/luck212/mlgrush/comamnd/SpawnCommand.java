package de.luck212.mlgrush.comamnd;

import com.avaje.ebean.validation.NotNull;
import de.luck212.mlgrush.main.Main;
import de.luck212.mlgrush.util.ConfigLocationUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    Main plugin;

    public SpawnCommand(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if(args.length == 1){
            if(args[1].equalsIgnoreCase("1")){
                ConfigLocationUtil configLocationUtil = new ConfigLocationUtil(plugin, player.getLocation(), args[1]);
                configLocationUtil.saveLocation();
                player.sendMessage("§6Die Location §a" + args[1] + " §6wurde gesetzt.");
            }else if(args[1].equalsIgnoreCase("2")){
                ConfigLocationUtil configLocationUtil = new ConfigLocationUtil(plugin, player.getLocation(), args[1]);
                configLocationUtil.saveLocation();
                player.sendMessage("§6Die Location §a" + args[1] + " §6wurde gesetzt.");
            }else
                player.sendMessage("§cBitte benutze §6/spawn <1 - 2>§c!");
        }else
            player.sendMessage("§cBitte benutze §6/spawn <1 - 2>§c!");

        return false;
    }
}