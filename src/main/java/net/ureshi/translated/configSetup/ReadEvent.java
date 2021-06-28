package net.ureshi.translated.configSetup;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ReadEvent extends Event {


    public ReadEvent() {
        Bukkit.getConsoleSender().sendMessage("splitSentences: ");
    }

    private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

}
