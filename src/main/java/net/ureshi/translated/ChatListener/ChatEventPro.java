package net.ureshi.translated.ChatListener;

import net.ureshi.translated.deepl.request.Pro;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

@SuppressWarnings("deprecation")
public class ChatEventPro implements Listener {
    public String originaltext;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerChat(AsyncPlayerChatEvent e, Pro pro) {
        originaltext = e.getMessage();
        e.setMessage(pro.translatedtext);
    }
}