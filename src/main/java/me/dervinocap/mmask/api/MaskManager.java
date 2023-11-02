package me.dervinocap.mmask.api;

import me.dervinocap.mmask.listeners.MaskEquip;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class MaskManager {

    public static Player getPlayersMasked() {

        for (Player player : Bukkit.getOnlinePlayers()) {

            if (MaskEquip.mascherato.contains(player.getUniqueId())) return player;

        }

        return null;
    }

    public static List getAllMaskedPlayers() {

        return MaskEquip.mascherato;
    }

}
