package net.ureshi.translated.ChatListener;

import net.ureshi.translated.Translated;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.io.IOException;

import static net.ureshi.translated.Translated.originaltext;
import static net.ureshi.translated.Translated.translatedtext;

@SuppressWarnings("deprecation")
public class ChatEventFree implements Listener {

    Translated.

    @EventHandler
    public void PlayerChat(PlayerChatEvent e) throws IOException {
        originaltext = e.getMessage();
        translated.Please();
        e.setMessage(translatedtext);
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Free Chat Called!");
    }
}
