package de.luck212.mlgrush.listener;

import de.luck212.mlgrush.main.Main;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;

public class BlockPlacedListener implements Listener {

    Main plugin;
    private ArrayList<Block> blocksPlaced;

    public BlockPlacedListener(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void handleBlockPlace(BlockPlaceEvent event){
        blocksPlaced.add(event.getBlockPlaced());
        plugin.setBlocksPlaced(blocksPlaced);
    }
}