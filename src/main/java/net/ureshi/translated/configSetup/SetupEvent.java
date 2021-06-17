package net.ureshi.translated.configSetup;

import net.ureshi.translated.Translated;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SetupEvent extends Event {


    public SetupEvent() {

        Translated.getCustomConfig().set("Auth Key:", "");
        Translated.getCustomConfig().set("Split Sentences", "default");

    }


    private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }


}
