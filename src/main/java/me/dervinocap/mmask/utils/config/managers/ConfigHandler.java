package me.dervinocap.mmask.utils.config.managers;

import me.dervinocap.mmask.MMask;
import me.dervinocap.mmask.utils.config.lib.ResourceConfig;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigHandler {

    private final MMask plugin;


    private ResourceConfig maskConfig;

    private MaskManager maskManager;

    public ConfigHandler(MMask plugin) {
        this.plugin = plugin;
    }

    public MMask getPlugin() {
        return this.plugin;
    }

    public ResourceConfig getMaskConfig() {
        return this.maskConfig;
    }

    public MaskManager getMaskManager() {
        return this.maskManager;
    }

    public void loadConfigs() {
        this.maskConfig = new ResourceConfig((JavaPlugin)this.plugin, "masks.yml", Boolean.valueOf(false));
        this.maskManager = new MaskManager(this.maskConfig.getCustomConfig());
        this.maskManager.loadMask();
    }

    public void reloadConfigs() {
        this.maskConfig.reloadConfig();
        this.maskManager.loadMask();
    }

}
