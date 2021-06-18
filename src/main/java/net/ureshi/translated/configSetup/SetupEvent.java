package net.ureshi.translated.configSetup;

import net.ureshi.translated.Translated;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SetupEvent extends Event {

    Translated translated = new Translated();

    public SetupEvent() {

        translated.getCustomConfig().set("Auth Key:", "");
        translated.getCustomConfig().set("Split Sentences", "True");
        translated.getCustomConfig().set("Preserve Formatting", "False");
        translated.getCustomConfig().set("Formality", "default");
        translated.saveConfig();
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
