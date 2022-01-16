package de.luck212.mlgrush.comamnd;

import de.luck212.mlgrush.main.Main;
import de.luck212.mlgrush.teams.TeamManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetTeamMemberCommand implements CommandExecutor {

    Main plugin;

    public SetTeamMemberCommand(Main plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if(args.length == 2){
            Player target = Bukkit.getPlayer(args[1]);
            if(target == null){
                player.sendMessage("§cDer Spieler " + args[1] + " wurde nicht gefunden");
                return false;
            }
            if(args[2].equalsIgnoreCase("1") || args[2].equalsIgnoreCase("2")){
                TeamManager teamManager = new TeamManager(target, args[2]);
                teamManager.setTeamMembers();
            }else
                player.sendMessage("§cBitte benutze §6/teamset <SPIELER> <1 - 2>");
        }else
            player.sendMessage("§cBitte benutze §6/teamset <SPIELER> <1 - 2>");
        return false;
    }
}