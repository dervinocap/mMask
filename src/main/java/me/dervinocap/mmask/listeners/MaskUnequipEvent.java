package me.dervinocap.mmask.listeners;

import me.dervinocap.mmask.utils.customloader.BasicsFunction;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MaskUnequipEvent implements Listener {

    @EventHandler
    public void unequipMask(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getSlot() != 39) return;

        if (player.getInventory().getHelmet() == null) return;

        if (!BasicsFunction.isMask(event.getCurrentItem())) return;

        if (BasicsFunction.checkMethod("Spigot")) {
            BasicsFunction.showNametag(player);
        }

        if (BasicsFunction.checkMethod("TAB")) {
            TabPlayer tabPlayer = TabAPI.getInstance().getPlayer(player.getUniqueId());
            TabAPI.getInstance().getNameTagManager().showNameTag(tabPlayer);
        }

    }

}
