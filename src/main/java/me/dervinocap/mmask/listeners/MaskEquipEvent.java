package me.dervinocap.mmask.listeners;

import com.cryptomorin.xseries.XSound;
import de.tr7zw.changeme.nbtapi.NBTItem;
import me.dervinocap.mmask.objects.Mask;
import me.dervinocap.mmask.utils.config.ConfigManager;
import me.dervinocap.mmask.utils.customloader.BasicsFunction;
import me.dervinocap.mmask.utils.customloader.PluginCustomLoader;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class MaskEquipEvent implements Listener {

    public static List<UUID> mascherato = new ArrayList<>();

    @EventHandler
    public void clickEvent(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if (event.getHand() != EquipmentSlot.HAND) return;

        if (event.getAction() != Action.RIGHT_CLICK_AIR) return;

        if (player.getInventory().getItemInMainHand() == null) return;

        if (!BasicsFunction.isMask(player.getInventory().getItemInMainHand())) return;

        NBTItem nbtItem = new NBTItem(player.getInventory().getItemInMainHand(), true);
        Mask mask = PluginCustomLoader.getInstance().getConfigHandler().getMaskManager().getMaskMap().get(nbtItem.getString("Mask"));

        if (mask == null) return;

        if (player.getInventory().getHelmet() != null) {
            player.sendMessage(ConfigManager.MESSAGE_ALREADY_WEARING.getFormattedString());
            return;
        }

        if (BasicsFunction.checkMethod("Spigot")) {
            BasicsFunction.hideNameTag(player);
        }

        if (BasicsFunction.checkMethod("TAB")) {
            TabPlayer tabPlayer = TabAPI.getInstance().getPlayer(player.getUniqueId());

            Objects.requireNonNull(TabAPI.getInstance().getNameTagManager()).hideNameTag(tabPlayer);
        }

        player.getInventory().setHelmet(player.getInventory().getItemInMainHand());
        player.getInventory().removeItem(player.getInventory().getItemInMainHand());
        player.playSound(player.getLocation(), XSound.ITEM_ARMOR_EQUIP_LEATHER.parseSound(), 1, 1);
        player.sendMessage(ConfigManager.MESSAGE_WORE.getFormattedString());
        mascherato.remove(player.getUniqueId());

    }

}
