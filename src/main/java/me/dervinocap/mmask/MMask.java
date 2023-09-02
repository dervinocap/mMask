package me.dervinocap.mmask;

import lombok.Getter;
import me.dervinocap.mmask.utils.customloader.PluginCustomLoader;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public final class MMask extends JavaPlugin {

    @Getter
    private static MMask instance;

    @Override
    public void onEnable() {

        instance = this;

        getLogger().info("███╗   ███╗███╗   ███╗");
        getLogger().info("████╗ ████║████╗ ████║");
        getLogger().info("██╔████╔██║██╔████╔██║");
        getLogger().info("██║╚██╔╝██║██║╚██╔╝██║");
        getLogger().info("██║ ╚═╝ ██║██║ ╚═╝ ██║");
        getLogger().info("╚═╝     ╚═╝╚═╝     ╚═╝");
        getLogger().info("Loading plugin...");
        PluginCustomLoader.getInstance().loadPlugin();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
