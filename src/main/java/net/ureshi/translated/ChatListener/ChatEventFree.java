package net.ureshi.translated.ChatListener;

import net.ureshi.translated.Translated;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

@SuppressWarnings("deprecation")
public class ChatEventFree implements Listener {

    @EventHandler
    public void PlayerChat(PlayerChatEvent e, Translated translated) {
        translated.originaltext = e.getMessage();
        e.setMessage(translated.translatedtext);
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Free Chat Called!");
    }
}
