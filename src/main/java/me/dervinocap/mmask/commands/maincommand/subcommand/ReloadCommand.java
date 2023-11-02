package me.dervinocap.mmask.commands.maincommand.subcommand;

import me.dervinocap.mmask.MMask;
import me.dervinocap.mmask.commands.SubCommand;
import me.dervinocap.mmask.utils.config.ConfigManager;
import me.dervinocap.mmask.utils.customloader.PluginCustomLoader;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand extends SubCommand {

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

        if (!player.hasPermission("mmask.reload")) {
            player.sendMessage(ConfigManager.MESSAGE_NO_PERMS.getFormattedString());
            return;
        }

        long start = System.currentTimeMillis();

        player.sendMessage(ConfigManager.MESSAGE_RELOAD.getFormattedString().replace("%ms%", String.valueOf(System.currentTimeMillis() - start)));

        PluginCustomLoader.getInstance().getConfigHandler().reloadConfigs();
        MMask.getInstance().reloadConfig();


    }
}
