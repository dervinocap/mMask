package me.dervinocap.mmask.utils.config.managers;

import com.cryptomorin.xseries.XMaterial;
import me.dervinocap.mmask.objects.Mask;
import me.dervinocap.mmask.utils.ColorAPI;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaskManager {

    private final FileConfiguration config;

    private final Map<String, Mask> maskMap;

    public MaskManager(FileConfiguration config) {
        this.maskMap = new HashMap<>();
        this.config = config;
    }

    public FileConfiguration getConfig() {
        return this.config;
    }

    public Map<String, Mask> getMaskMap() {
        return this.maskMap;
    }

    public void loadMask() {
        this.maskMap.clear();
        this.config.getConfigurationSection("Masks.").getKeys(false).forEach(maskId -> {

            String lowerCaseTaserId = maskId.toLowerCase();

            String displayName = ColorAPI.getFormattedString(getValue(maskId + ".item-name"));

            String chatFormat = ColorAPI.getFormattedString(getValue(maskId + ".chat-format"));

            List<String> lore = ColorAPI.getFormattedStringList(getListValue(maskId + ".lore"));

            XMaterial material = XMaterial.valueOf(getValue(maskId + ".material"));

            Integer distance = Integer.valueOf(getValue(maskId + ".distance"));

            Mask mask = new Mask(lowerCaseTaserId, displayName, new ItemStack(material.parseItem()), chatFormat, distance);
            mask.getLore().addAll(lore);
            this.maskMap.put(lowerCaseTaserId, mask);
            System.out.println("§9[mMask] §f " + lowerCaseTaserId + " §bcaricato con successo!");
        });
    }

    private String getValue(String key) {
        return this.config.getString("Masks." + key);
    }

    private List<String> getListValue(String key) {
        return this.config.getStringList("Masks." + key);
    }

}
