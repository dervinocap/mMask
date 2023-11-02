package me.dervinocap.mmask.listeners;

import me.dervinocap.mmask.utils.customloader.BasicsFunction;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class MaskJoin implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if (player.getInventory().getHelmet() == null) return;

        if (BasicsFunction.isMask(player.getInventory().getHelmet())) return;

        if (BasicsFunction.checkMethod("Spigot")) {
            BasicsFunction.hideNameTag(player);
        }

        if (BasicsFunction.checkMethod("TAB")) {
            TabPlayer tabPlayer = TabAPI.getInstance().getPlayer(player.getUniqueId());
            Objects.requireNonNull(TabAPI.getInstance().getNameTagManager()).hideNameTag(tabPlayer);
        }

        MaskEquip.mascherato.add(player.getUniqueId());

    }

}
