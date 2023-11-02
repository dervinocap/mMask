package me.dervinocap.mmask.events;

import lombok.Getter;
import lombok.Setter;
import me.dervinocap.mmask.objects.Mask;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class MaskUnequipEvent extends org.bukkit.event.Event implements Cancellable {

    @Getter
    @Setter
    private Mask mask;

    @Getter @Setter
    private Player player;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;

    public MaskUnequipEvent(Mask mask, Player player){
        this.mask = mask;
        this.player = player;
        this.isCancelled = false;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
