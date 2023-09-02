package me.dervinocap.mmask.utils.customloader;

import de.tr7zw.changeme.nbtapi.NBTItem;
import me.dervinocap.mmask.utils.config.ConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Team;

public class BasicsFunction {

    public static boolean isMask(ItemStack item) {
        NBTItem nbti = new NBTItem(item);
        if (nbti.getString("Mask") != null)
            return true;
        return false;
    }

    public static boolean checkMethod(String method) {
        if (ConfigManager.SETTINGS_METHODS.getString().equalsIgnoreCase(method)) {
            return true;
        }
        return false;
    }

    public static void hideNameTag(Player player) {
        Team team = player.getScoreboard().getTeam(player.getName());
        if (team == null) {
            team = player.getScoreboard().registerNewTeam(player.getName());
        }

        team.addPlayer(player);
        team.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.NEVER);
    }

    public static void showNametag(Player player) {
        Team team = player.getScoreboard().getTeam(player.getName());
        if (team != null) {
            team.removePlayer(player);
        }
    }


}
