package me.dervinocap.mmask.commands;

import me.dervinocap.mmask.utils.config.ConfigManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDExecutionValidator {

    public static boolean validate(SubCommand command, CommandSender sender) {


        if (command.isPlayerOnly() && !(sender instanceof Player)) {
            sender.sendMessage("§cOnly player can write this command!");
            return false;
        }

        if (command.getPermission() != null && !sender.hasPermission(command.getPermission()) && !(sender.hasPermission("*") || !sender.isOp() || sender.hasPermission("mmask.*"))) {
            sender.sendMessage(ConfigManager.MESSAGE_NO_PERMS.getFormattedString());
            return false;
        }

        return true;
    }

}
