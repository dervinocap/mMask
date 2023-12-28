package me.dervinocap.mmask.listeners;

import de.tr7zw.changeme.nbtapi.NBTItem;
import me.dervinocap.mmask.objects.Mask;
import me.dervinocap.mmask.utils.config.ConfigManager;
import me.dervinocap.mmask.utils.customloader.BasicsFunction;
import me.dervinocap.mmask.utils.customloader.PluginCustomLoader;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MaskChatEvent implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {

        Player player = event.getPlayer();

        if (player.getInventory().getHelmet() == null) return;

        if (!BasicsFunction.isMask(player.getInventory().getHelmet())) return;

        NBTItem nbtItem = new NBTItem(player.getInventory().getHelmet(), true);
        Mask mask = PluginCustomLoader.getInstance().getConfigHandler().getMaskManager().getMaskMap().get(nbtItem.getString("Mask"));

        if (mask == null) return;

        event.setCancelled(true);

        System.out.println(mask.getChatFormat().replace("%message%", event.getMessage()).replace(mask.getChatFormat(), mask.getChatFormat() + "§f(" + player + ")"));

        if (ConfigManager.SETTINGS_CHAT_DISTANCE.getBoolean()) {

            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {

                if (onlinePlayer.getLocation().distance(player.getLocation()) <= mask.getDistance())
                    onlinePlayer.sendMessage(mask.getChatFormat().replace("%message%", ConfigManager.getFormattedString(event.getMessage())));

            }

        } else {
            Bukkit.getServer().broadcastMessage(mask.getChatFormat().replace("%message%", ConfigManager.getFormattedString(event.getMessage())));
        }


    }

}
