package src.main.zvolcan.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import src.main.zvolcan.OnlyStoneDrop;

public class BlockBreakListener implements Listener {

    private final OnlyStoneDrop pl;

    public BlockBreakListener(OnlyStoneDrop pl) {
        this.pl = pl;
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event) {
        Material type = event.getBlock().getType();
        if (type == Material.DIORITE || type == Material.ANDESITE || type == Material.GRANITE || type == Material.getMaterial("TUFF") || type == Material.getMaterial("DEEPSLATE")){
            if (!pl.isEnable()) return;
            Location location = event.getBlock().getLocation();
            event.setDropItems(false);
            location.getWorld().dropItem(location.add(0.5, 0.5, 0.5), new ItemStack(Material.COBBLESTONE));
        }
    }

}
