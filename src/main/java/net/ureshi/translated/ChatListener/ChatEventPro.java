package net.ureshi.translated.ChatListener;

import net.ureshi.translated.Translated;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.IOException;

import static net.ureshi.translated.Translated.originaltext;
import static net.ureshi.translated.Translated.translatedtext;

@SuppressWarnings("deprecation")
public class ChatEventPro implements Listener {

    Translated translated = new Translated();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerChat(AsyncPlayerChatEvent e) throws IOException {
        originaltext = e.getMessage();
        translated.Please();
        e.setMessage(translatedtext);
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Pro Chat Called!");
    }
}