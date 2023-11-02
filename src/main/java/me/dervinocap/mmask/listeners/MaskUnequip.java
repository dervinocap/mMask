package me.dervinocap.mmask.listeners;

import de.tr7zw.changeme.nbtapi.NBTItem;
import me.dervinocap.mmask.MMask;
import me.dervinocap.mmask.events.MaskUnequipEvent;
import me.dervinocap.mmask.objects.Mask;
import me.dervinocap.mmask.utils.customloader.BasicsFunction;
import me.dervinocap.mmask.utils.customloader.PluginCustomLoader;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MaskUnequip implements Listener {

    @EventHandler
    public void unequipMask(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getSlot() != 39) return;

        if (player.getInventory().getHelmet() == null) return;

        if (!BasicsFunction.isMask(event.getCurrentItem())) return;

        NBTItem nbtItem = new NBTItem(event.getCurrentItem(), true);
        Mask mask = PluginCustomLoader.getInstance().getConfigHandler().getMaskManager().getMaskMap().get(nbtItem.getString("Mask"));

        if (mask == null) return;

        if (BasicsFunction.checkMethod("Spigot")) {
            BasicsFunction.showNametag(player);
        }

        if (BasicsFunction.checkMethod("TAB")) {
            TabPlayer tabPlayer = TabAPI.getInstance().getPlayer(player.getUniqueId());
            TabAPI.getInstance().getNameTagManager().showNameTag(tabPlayer);
        }

        MaskEquip.mascherato.remove(player.getUniqueId());

        MaskUnequipEvent maskUnequipEvent = new MaskUnequipEvent(mask, player);

        maskUnequipEvent.setMask(mask);
        maskUnequipEvent.setPlayer(player);

        if (event.isCancelled()) {
            maskUnequipEvent.setCancelled(true);
        }

        if (maskUnequipEvent.isCancelled()) {
            event.setCancelled(true);
        }

        MMask.getInstance().getServer().getPluginManager().callEvent(maskUnequipEvent);

    }

}
