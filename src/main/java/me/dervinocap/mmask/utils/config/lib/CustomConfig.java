package me.dervinocap.mmask.utils.config.lib;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class CustomConfig {

    private final JavaPlugin plugin;

    private final String directory;

    private File customConfigFile;

    private FileConfiguration customConfig;

    public File getCustomConfigFile() {
        return this.customConfigFile;
    }

    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

    public void loadConfig() throws IOException {
        try {
            this.customConfigFile = new File(this.plugin.getDataFolder(), this.directory);
            if (!this.plugin.getDataFolder().exists())
                this.plugin.getDataFolder().mkdir();
            if (!this.customConfigFile.exists())
                this.customConfigFile.createNewFile();
            this.customConfig = (FileConfiguration) YamlConfiguration.loadConfiguration(this.customConfigFile);
        } catch (Throwable $ex) {
            throw $ex;
        }
    }

    public void reloadConfig() {
        try {
            this.customConfig.load(this.customConfigFile);
        } catch (IOException | org.bukkit.configuration.InvalidConfigurationException e) {
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

    public <T extends JavaPlugin> CustomConfig(T plugin, String directory) {
        this.plugin = (JavaPlugin)plugin;
        this.directory = directory;
    }

}

