package net.ureshi.translated.PlayerProfile;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

public class JoinEvent implements Listener {

    public static HashMap<Player, String> language = new HashMap<>();

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e) {

        Player p = e.getPlayer();



    }
}
