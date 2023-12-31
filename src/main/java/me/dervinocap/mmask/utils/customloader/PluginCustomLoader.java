package me.dervinocap.mmask.utils.customloader;

import lombok.Getter;
import me.dervinocap.mmask.MMask;
import me.dervinocap.mmask.commands.maincommand.MMainCommand;
import me.dervinocap.mmask.commands.maincommand.TabComplete;
import me.dervinocap.mmask.listeners.*;
import me.dervinocap.mmask.utils.config.managers.ConfigHandler;
import org.bukkit.Bukkit;

import static org.bukkit.Bukkit.*;

public class PluginCustomLoader {

    @Getter(lazy = true)
    private static final PluginCustomLoader instance = new PluginCustomLoader();

    private ConfigHandler configHandler;

    private final MMask plugin = MMask.getInstance();

    @Getter
    private final String pluginVersion = plugin.getDescription().getVersion();

    public ConfigHandler getConfigHandler() {
        return this.configHandler;
    }

    private void loadConfig() {
        getLogger().info("Loading Config...");
        this.configHandler = new ConfigHandler(this.plugin);
        this.configHandler.loadConfigs();
    }

    public void loadMisc() {

        if (getServer().getPluginManager().getPlugin("TAB") == null) return;

        plugin.getConfig().set(".Settings.method", "TAB");
        getLogger().info("§fTAB§9 detected! Setting TAB method in config...");
        plugin.saveConfig();


    }

    private void loadListeners() {
        getLogger().info("Loading Listeners...");

        Bukkit.getPluginManager().registerEvents(new MaskEquip(), plugin);
        Bukkit.getPluginManager().registerEvents(new MaskUnequip(), plugin);
        Bukkit.getPluginManager().registerEvents(new MaskChatEvent(), plugin);
        Bukkit.getPluginManager().registerEvents(new MaskJoin(), plugin);
        Bukkit.getPluginManager().registerEvents(new MaskDeathEvent(), plugin);

    }

    private void loadCommands() {
        getLogger().info("Loading Commands...");
        getPluginCommand("mmask").setExecutor(new MMainCommand());

    }

    private void loadTabCompleters() {

        getPluginCommand("mmask").setTabCompleter(new TabComplete());

    }




    // MAIN METHODS

    public void loadPlugin() {

        loadConfig();

        loadListeners();
        loadCommands();
        loadTabCompleters();
        plugin.saveDefaultConfig();
        loadMisc();

    }

    public void disablePlugin() {

    }

}
