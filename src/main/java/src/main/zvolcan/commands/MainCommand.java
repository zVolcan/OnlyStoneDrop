package src.main.zvolcan.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import src.main.zvolcan.OnlyStoneDrop;

public class MainCommand implements CommandExecutor {

    private final OnlyStoneDrop pl;

    public MainCommand(OnlyStoneDrop pl) {
        this.pl = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (player.hasPermission("onlystonedrops.toggle")) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&aOnlyStoneDrop&8] &7Usage: /osd enable | disable"));
            } else {
                switch (args[0].toLowerCase()) {
                    case "enable": {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&aOnlyStoneDrop&8] &aOnlyStoneDrop enable!"));
                        this.pl.setEnable(true);
                        break;
                    }
                    case "disable": {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&aOnlyStoneDrop&8] &cOnlyStoneDrop disable!"));
                        this.pl.setEnable(false);
                        break;
                    }
                    default: {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&aOnlyStoneDrop&8] &7Usage: /osd enable | disable"));
                        break;
                    }
                }
                return true;
            }
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&aOnlyStoneDrop&8] &cYou do not have permissions to run this command!"));
            return true;
        }

        return true;
    }
}
