package me.dervinocap.mmask.gui;

import com.cryptomorin.xseries.XMaterial;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import dev.triumphteam.gui.guis.PaginatedGui;
import me.dervinocap.mmask.utils.config.ConfigManager;
import me.dervinocap.mmask.utils.config.managers.MaskManager;
import me.dervinocap.mmask.utils.customloader.PluginCustomLoader;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class MaskGUI {

    private static final MaskManager maskManager = PluginCustomLoader.getInstance().getConfigHandler().getMaskManager();

    public static void open(Player player) {

        PaginatedGui gui = ((Gui.paginated().title(Component.text("§7§lmMask§7 Masks"))).rows(6)).create();

        gui.getFiller().fillBorder(ItemBuilder.from(XMaterial.WHITE_STAINED_GLASS_PANE.parseItem()).asGuiItem());

        maskManager.getMaskMap().forEach((maskId, mask) -> gui.addItem(ItemBuilder.from(mask.getMaskItem()).asGuiItem(event -> {

            player.getInventory().addItem(mask.getMaskItem());

        })));

        gui.setItem(6, 3, ItemBuilder.from(Material.PAPER).setName(ConfigManager.ITEM_PREVIOUS.getFormattedString()).asGuiItem(event -> gui.previous()));
        gui.setItem(6, 7, ItemBuilder.from(Material.PAPER).setName(ConfigManager.ITEM_NEXT.getFormattedString()).asGuiItem(event -> gui.next()));

        gui.setDefaultClickAction(event -> {
            event.setCancelled(true);
        });

        gui.setDefaultClickAction(event -> event.setCancelled(true));
        gui.open(player);
    }

}
