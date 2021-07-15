package net.ureshi.translated.ChatListener;

import net.ureshi.translated.deepl.request.Pro;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.ureshi.translated.Translated.*;

public class ChatEventPro implements Listener {



    @SuppressWarnings("deprecation")
    @EventHandler
    public void PlayerChat(AsyncPlayerChatEvent e) throws IOException {

        originalText = e.getMessage();
        Bukkit.getPluginManager().callEvent(new Pro());
        byte[] temp1 = translatedText.getBytes(StandardCharsets.ISO_8859_1);
        String message = new String(temp1, StandardCharsets.UTF_8);
        e.setMessage(message);
        if(en.equals("True")){
            Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Free Chat Called!");
        }

    }
}