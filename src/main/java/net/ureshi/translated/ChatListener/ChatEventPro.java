package net.ureshi.translated.ChatListener;

import net.ureshi.translated.Translated;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

@SuppressWarnings("deprecation")
public class ChatEventPro implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerChat(AsyncPlayerChatEvent e, Translated translated) {
        translated.originaltext = e.getMessage();
        e.setMessage(translated.translatedtext);
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Pro Chat Called!");
    }
}