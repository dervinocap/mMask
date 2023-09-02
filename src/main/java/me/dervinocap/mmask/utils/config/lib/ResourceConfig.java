package me.dervinocap.mmask.utils.config.lib;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class ResourceConfig {
    private final JavaPlugin plugin;

    private final String directory;

    private final Boolean replace;

    private File customConfigFile;

    private FileConfiguration customConfig;

    public File getCustomConfigFile() {
        return this.customConfigFile;
    }

    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

    public void loadConfig() {
        this.customConfigFile = new File(this.plugin.getDataFolder() + File.separator + this.directory.replace("/", File.separator));
        if (!this.customConfigFile.exists()) {
            this.customConfigFile.getParentFile().mkdirs();
            this.plugin.saveResource(this.directory, this.replace.booleanValue());
        }
        this.customConfig = (FileConfiguration)new YamlConfiguration();
        try {
            this.customConfig.load(this.customConfigFile);
        } catch (IOException | org.bukkit.configuration.InvalidConfigurationException e) {
            e.printStackTrace();
        }
        saveConfig();
    }

    public void reloadConfig() {
        try {
            this.customConfig.load(this.customConfigFile);
        } catch (IOException|org.bukkit.configuration.InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveConfig() {
        try {
            this.customConfig.save(this.customConfigFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends JavaPlugin> ResourceConfig(T plugin, String directory, Boolean replace) {
        this.plugin = (JavaPlugin)plugin;
        this.directory = directory;
        this.replace = replace;
        loadConfig();
    }

}
