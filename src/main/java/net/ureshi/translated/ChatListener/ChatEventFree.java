package net.ureshi.translated.ChatListener;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.ureshi.translated.deepl.request.Free;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.ureshi.translated.Translated.*;

public class ChatEventFree implements Listener {

    public static String uuid;

    @SuppressWarnings("deprecation")
    @EventHandler
    public void PlayerChat(AsyncChatEvent e) throws IOException {

        originalText = e.getMessage();
        uuid = e.getPlayer().getUniqueId().toString();

        new Free();

        byte[] temp1 = translatedText.getBytes(StandardCharsets.ISO_8859_1);
        String message = new String(temp1, StandardCharsets.UTF_8);
        e.setMessage(message);

        if(en.equals("True")){
            Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Free Chat Called!");
        }

    }
}