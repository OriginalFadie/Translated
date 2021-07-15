package net.ureshi.translated.PlayerProfile;

import net.ureshi.translated.Translated;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;



public class JoinEvent implements Listener {



    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e) {

        String lang;
        Bukkit.getConsoleSender().sendMessage("PlayerJoinEvent Called");
        Player p = e.getPlayer();
        String uuid = p.getUniqueId().toString();
        NamespacedKey key = new NamespacedKey(Translated.getInstance(), "langKey");
        PersistentDataContainer container = p.getPersistentDataContainer();
        if (!p.hasPlayedBefore()) {
            Translated.getInstance().getConfig().set("player", uuid);
            Translated.getInstance().getConfig().set("player." + uuid + ".lang", "En");
            lang = "En";
            Translated.getInstance().saveConfig();
            Bukkit.getConsoleSender().sendMessage("!p.hasPlayedBefore called!");
        }else {
            lang = Translated.getInstance().getConfig().getString("player." + uuid + ".lang");
            Bukkit.getConsoleSender().sendMessage("p.hasPlayedBefore called!");
        }
        container.set(key, PersistentDataType.STRING, lang);
        Bukkit.getConsoleSender().sendMessage("Container set key called!");
        if (container.has(key, PersistentDataType.STRING)) {
            Bukkit.getConsoleSender().sendMessage("The player's Key is: " + container.get(key, PersistentDataType.STRING));
        }


    }
}
