package de.luck212.mlgrush.mlginv;

import de.luck212.mlgrush.main.Main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MLGInventory {

    Player player;

    public MLGInventory(Player player){
        this.player = player;
    }

    public void fillInventory(){
        ItemStack stick = new ItemStack(Material.STICK);
        stick.addEnchantment(Enchantment.KNOCKBACK, 1);
        player.getInventory().setItem(0, stick);
        player.getInventory().setItem(1, new ItemStack(Material.STONE_PICKAXE));
        player.getInventory().setItem(7, new ItemStack(Material.SANDSTONE, 64));
        player.getInventory().setItem(8, new ItemStack(Material.SANDSTONE, 64));
    }

    public void clearInventory(){
        player.getInventory().clear();
    }
}