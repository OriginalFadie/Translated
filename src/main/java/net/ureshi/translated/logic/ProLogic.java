package net.ureshi.translated.logic;

import net.ureshi.translated.deepl.request.Pro;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ProEvent implements Listener {

    @SuppressWarnings("deprecation")
    @EventHandler(priority = EventPriority.HIGH)
    public void ProEvent(AsyncPlayerChatEvent e, Pro pro) {
        if (!e.getMessage().contains("aksasjmuaknmikiaosdiopgajnwijkipoadikwajiiwaodofkpoadikwoadkopadjiuawjtduasdlpwjadokpdfp[as][dplawkoduiaw9dolsdlwnjajidu8sadopwp]a0-dw90iu8hgfu8w9aiuopsdl;fgmawndgwtgdthufikofwlp")) {
            Bukkit.getServer().getPluginManager().callEvent(pro);
        }
    }
}
