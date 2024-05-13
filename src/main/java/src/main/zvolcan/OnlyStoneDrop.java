package src.main.zvolcan;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import src.main.zvolcan.commands.MainCommand;
import src.main.zvolcan.listeners.BlockBreakListener;

public final class OnlyStoneDrop extends JavaPlugin {

    private boolean enable;

    public OnlyStoneDrop() {
        enable = true;
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(this), this);
        Bukkit.getServer().getPluginCommand("onlystonedrop").setExecutor(new MainCommand(this));
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
