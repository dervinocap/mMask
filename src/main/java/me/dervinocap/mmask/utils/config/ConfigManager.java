package me.dervinocap.mmask.utils.config;

import com.cryptomorin.xseries.XMaterial;
import me.dervinocap.mmask.MMask;
import net.md_5.bungee.api.ChatColor;

import java.util.List;

public enum ConfigManager {

    // MESSAGE

    MESSAGE_UNKNOW_COMMAND(".Message.unknown-command"),
    MESSAGE_ALREADY_WEARING(".Message.already-wearing"),
    MESSAGE_WORE(".Message.wore"),
    MESSAGE_NO_PERMS(".Message.no-perms"),
    MESSAGE_RELOAD(".Message.reload"),

    // SETTINGS

    SETTINGS_METHODS(".Settings.method"),
    SETTINGS_CHAT_DISTANCE(".Settings.chat-distance"),

    // ITEM

    ITEM_NEXT(".Item.next"),
    ITEM_PREVIOUS(".Item.previous");

    private final String path;

    private ConfigManager(String path) {
        this.path = path;
    }

    public boolean getBoolean() {
        return MMask.getInstance().getConfig().getBoolean(this.path);
    }

    public String getFormattedString() {
        return ChatColor.translateAlternateColorCodes('&', MMask.getInstance().getConfig().getString(this.path));
    }

    public XMaterial getMaterial() {
        return XMaterial.matchXMaterial(MMask.getInstance().getConfig().getString(this.path)).get();
    }

    public String getString() {
        return MMask.getInstance().getConfig().getString(this.path);
    }

    public int getInt() {
        return MMask.getInstance().getConfig().getInt(this.path);
    }

    public List<String> getStringList() {
        return MMask.getInstance().getConfig().getStringList(this.path);
    }

    public static String getFormattedString(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
