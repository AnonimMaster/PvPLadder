package io.github.AnonimMaster.PvPLadder.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LanguageSwitchEvent extends Event {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    public LanguageSwitchEvent() {
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}
