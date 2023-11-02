package me.dervinocap.mmask.commands.maincommand.subcommand;

import me.dervinocap.mmask.commands.SubCommand;
import me.dervinocap.mmask.gui.MaskGUI;
import me.dervinocap.mmask.utils.config.ConfigManager;
import me.dervinocap.mmask.utils.customloader.PluginCustomLoader;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetItemCommand extends SubCommand {

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

        if (args.length > 1) return;

        if (!player.hasPermission("mmask.get")) {
            player.sendMessage(ConfigManager.MESSAGE_NO_PERMS.getFormattedString());
            return;
        }

        MaskGUI.open(player);


    }
}
