package me.dervinocap.mmask.commands.maincommand;

import lombok.Getter;
import me.dervinocap.mmask.commands.CMDExecutionValidator;
import me.dervinocap.mmask.commands.SubCommand;
import me.dervinocap.mmask.commands.maincommand.subcommand.GetItemCommand;
import me.dervinocap.mmask.commands.maincommand.subcommand.HelpCommand;
import me.dervinocap.mmask.commands.maincommand.subcommand.InfoCommand;
import me.dervinocap.mmask.commands.maincommand.subcommand.ReloadCommand;
import me.dervinocap.mmask.utils.config.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class MMainCommand implements CommandExecutor {


    @Getter
    public static final Map<String, SubCommand> subCommands = new HashMap<>();
    public void register(String subCommandName, SubCommand command) {
        subCommands.put(subCommandName, command);
    }

    public MMainCommand() {
        register("help", new HelpCommand());
        register("get", new GetItemCommand());
        register("info", new InfoCommand());
        register("reload", new ReloadCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String unknown_command = ConfigManager.MESSAGE_UNKNOW_COMMAND.getFormattedString();

        if (args.length == 0) {
            sender.sendMessage(unknown_command);
            return false;
        }

        String argument = args[0].toLowerCase();
        SubCommand commandToExecute = subCommands.get(argument);

        if (subCommands.get(argument) == null) {
            sender.sendMessage(unknown_command);
            return false;
        }

        if (!CMDExecutionValidator.validate(commandToExecute, sender)) return false;

        commandToExecute.execute(sender, args);

        return true;
    }
}
