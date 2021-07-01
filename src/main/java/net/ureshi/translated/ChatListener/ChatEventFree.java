package net.ureshi.translated.ChatListener;

import net.ureshi.translated.Translated;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


import java.io.IOException;

import static net.ureshi.translated.Translated.originaltext;
import static net.ureshi.translated.Translated.translatedtext;

public class ChatEventFree implements Listener {

    @SuppressWarnings("deprecation")
    @EventHandler
    public void PlayerChat(AsyncPlayerChatEvent e) throws IOException {
        originaltext = e.getMessage();
        Bukkit.getConsoleSender().sendMessage(""+originaltext);
        Translated.Please();
        e.setMessage(translatedtext);
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Free Chat Called!");
    }
}
