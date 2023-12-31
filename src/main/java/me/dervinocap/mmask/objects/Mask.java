package me.dervinocap.mmask.objects;

import com.cryptomorin.xseries.XMaterial;
import de.tr7zw.changeme.nbtapi.NBTItem;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Mask {

    @Getter
    private final String id;

    @Getter
    private final String name;

    @Getter
    private final List<String> lore;

    @Getter
    private final ItemStack material;

    @Getter
    private final Integer customModelData;

    @Getter
    private final String chatFormat;

    @Getter
    private final Integer distance;

    public Mask(String id, String name, ItemStack material, String chatFormat, Integer distance, Integer customModelData) {

        this.lore = new ArrayList<>();
        this.id = id;
        this.name = name;
        this.material = material;
        this.chatFormat = chatFormat;
        this.distance = distance;
        this.customModelData = customModelData;

    }

    public ItemStack getMaskItem() {

        XMaterial xMaterial = XMaterial.matchXMaterial(getMaterial());
        ItemStack itemStack = xMaterial.parseItem();

        NBTItem nbtItem = new NBTItem(itemStack, true);
        ItemMeta meta = nbtItem.getItem().getItemMeta();

        meta.setDisplayName(getName());
        meta.setLore(getLore());
        meta.setUnbreakable(true);

        if (Bukkit.getVersion().contains("1.14")) {
            meta.setCustomModelData(getCustomModelData());
        }

        if (Bukkit.getVersion().contains("1.15")) {
            meta.setCustomModelData(getCustomModelData());
        }

        if (Bukkit.getVersion().contains("1.16")) {
            meta.setCustomModelData(getCustomModelData());
        }

        if (Bukkit.getVersion().contains("1.17")) {
            meta.setCustomModelData(getCustomModelData());
        }

        if (Bukkit.getVersion().contains("1.18")) {
            meta.setCustomModelData(getCustomModelData());
        }

        if (Bukkit.getVersion().contains("1.19")) {
            meta.setCustomModelData(getCustomModelData());
        }

        if (Bukkit.getVersion().contains("1.20")) {
            meta.setCustomModelData(getCustomModelData());
        }

        nbtItem.getItem().setItemMeta(meta);
        nbtItem.setString("Mask", getId());


        return nbtItem.getItem();
    }

}
