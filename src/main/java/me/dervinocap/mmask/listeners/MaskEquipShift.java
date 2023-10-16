package me.dervinocap.mmask.listeners;

import de.tr7zw.changeme.nbtapi.NBTItem;
import me.dervinocap.mmask.objects.Mask;
import me.dervinocap.mmask.utils.customloader.BasicsFunction;
import me.dervinocap.mmask.utils.customloader.PluginCustomLoader;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class MaskEquipShift implements Listener {

    @EventHandler
    public void clickInvEvent(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (!event.getClick().isShiftClick()) return;

        if (!BasicsFunction.isMask(event.getCurrentItem())) return;

        NBTItem nbtItem = new NBTItem(event.getCurrentItem(), true);
        Mask mask = PluginCustomLoader.getInstance().getConfigHandler().getMaskManager().getMaskMap().get(nbtItem.getString("Mask"));

        if (mask == null) return;

        if (player.getInventory().getHelmet() != null) {
            return;
        }

        TabPlayer tabPlayer = TabAPI.getInstance().getPlayer(player.getUniqueId());

        Objects.requireNonNull(TabAPI.getInstance().getNameTagManager()).hideNameTag(tabPlayer);

        player.getInventory().setHelmet(mask.getMaskItem());
        player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_LEATHER, 1, 1);

        player.getInventory().removeItem(mask.getMaskItem());

    }
}
