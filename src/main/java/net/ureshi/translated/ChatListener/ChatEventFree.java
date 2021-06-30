package net.ureshi.translated.ChatListener;

import net.ureshi.translated.deepl.request.Free;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

@SuppressWarnings("deprecation")
public class ChatEventFree implements Listener {
    public String originaltext;


    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerChat(AsyncPlayerChatEvent e, Free free) {
        originaltext = e.getMessage();
        e.setMessage(free.translatedtext);
    }
}
