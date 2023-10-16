package me.dervinocap.mmask.listeners;

import me.dervinocap.mmask.utils.customloader.BasicsFunction;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class MaskDeathEvent implements Listener {

    @EventHandler
    public void playerDeath(PlayerDeathEvent event) {

        Player player = event.getEntity();

        if (player.getInventory().getHelmet() == null) return;

        if (!BasicsFunction.isMask(player.getInventory().getHelmet())) return;

        if (BasicsFunction.checkMethod("Spigot")) {
            BasicsFunction.showNametag(player);
        }

        if (BasicsFunction.checkMethod("TAB")) {
            TabPlayer tabPlayer = TabAPI.getInstance().getPlayer(player.getUniqueId());
            TabAPI.getInstance().getNameTagManager().showNameTag(tabPlayer);
        }

    }

}
