package net.jitse.simplefactions.commands;

import net.jitse.simplefactions.factions.Role;
import org.bukkit.event.Listener;

/**
 * Created by Jitse on 25-6-2017.
 */
public abstract class SubCommand implements ICommand, Listener {

    private final Role role;
    private final String permission;

    public SubCommand(Role role, String permission) {
        this.role = role;
        this.permission = permission;
    }

    public Role getRole(){
        return this.role;
    }

    public String getPermission(){
        return this.permission;
    }
}
