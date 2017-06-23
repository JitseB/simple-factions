package net.jitse.simplefactions.factions;

import net.jitse.simplefactions.utilities.Logger;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by Jitse on 23-6-2017.
 */
public class Member {

    private final UUID uuid;
    private Role role;

    public Member(UUID uuid, Role role){
        this.uuid = uuid;
        this.role = role;
    }

    public UUID getUUID(){
        return this.uuid;
    }

    public Role getRole(){
        return this.role;
    }

    public Player getPlayer() {
        Player player = Bukkit.getPlayer(this.uuid);
        if(player == null)
            Logger.log(Logger.LogLevel.ERROR, "Tried to use Member#getPlayer without null check, player is not online.");
        return player;
    }

    public OfflinePlayer getOfflinePlayer() {
        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(this.uuid);
        if(offlinePlayer == null)
            Logger.log(Logger.LogLevel.ERROR, "Tried to use Member#getOfflinePlayer without null check, player never logged on.");
        return offlinePlayer;
    }
}