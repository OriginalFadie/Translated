package net.ureshi.translated.Storage;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class FileStorage extends Event {

    private static final HandlerList HANDLERS = new HandlerList();


    public void File() {
        Bukkit.getConsoleSender().sendMessage("File Called!");
    }

    @Override
    public @NotNull HandlerList getHandlers() { return null; }

}
