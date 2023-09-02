package me.dervinocap.mmask.commands.maincommand.subcommand;

import me.dervinocap.mmask.commands.SubCommand;
import me.dervinocap.mmask.utils.customloader.PluginCustomLoader;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand extends SubCommand {

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

        if (!player.hasPermission("mmask.help")) return;

        player.sendMessage("");
        player.sendMessage("§9§lmMask MainCommand");
        player.sendMessage("§8• §f/mmask get");
        player.sendMessage("§8• §f/mmask info");
        player.sendMessage("§8• §f/mmask help");
        player.sendMessage("§8• §f/mmask reload");
        player.sendMessage("");


    }
}
