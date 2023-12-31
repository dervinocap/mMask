package me.dervinocap.mmask.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class ColorAPI {
    public static List<String> getFormattedStringList(List<String> stringList) {
        List<String> formattedLore = new ArrayList<>();
        stringList.forEach(s -> formattedLore.add(getFormattedString(s)));
        return formattedLore;
    }

    public static String getFormattedString(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
