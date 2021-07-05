package net.ureshi.translated.ChatListener;

import net.ureshi.translated.Translated;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.IOException;

import static net.ureshi.translated.Translated.originalText;
import static net.ureshi.translated.Translated.translatedText;

public class ChatEventPro implements Listener {

    @SuppressWarnings("deprecation")
    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerChat(AsyncPlayerChatEvent e) throws IOException {
        originalText = e.getMessage();
        e.setMessage(translatedText);
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Pro Chat Called!");
    }
}