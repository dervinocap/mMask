package me.dervinocap.mmask.commands.maincommand.subcommand;

import me.dervinocap.mmask.commands.SubCommand;
import me.dervinocap.mmask.utils.customloader.PluginCustomLoader;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoCommand extends SubCommand {

    @Override
    public boolean isPlayerOnly() {
        return false;
    }

    @Override
    public String getPermission() {
        return null;
    }

    private final PluginCustomLoader customLoader = PluginCustomLoader.getInstance();

    @Override
    public void execute(CommandSender sender, String[] args) {

        Player player = (Player) sender;

        player.sendMessage("");
        player.sendMessage("§9§lmMask Info");
        player.sendMessage("");
        player.sendMessage("§7Made by @Dervone");
        player.sendMessage("§7Version v1.1");
        player.sendMessage("§7@DerviWorks");
        player.sendMessage("");


    }
}
