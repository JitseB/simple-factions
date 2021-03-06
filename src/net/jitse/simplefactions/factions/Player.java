package net.jitse.simplefactions.factions;

import net.jitse.simplefactions.SimpleFactions;
import net.jitse.simplefactions.utilities.Logger;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Scoreboard;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by Jitse on 26-6-2017.
 */
public class Player {

    private final UUID uuid;
    private int power;
    private Timestamp lastseen;
    private boolean sidebar;
    private Faction location;

    public Player(UUID uuid, int power, Timestamp lastseen, boolean sidebar){
        this.uuid = uuid;
        this.power = power;
        this.lastseen = lastseen;
        this.sidebar = sidebar;
        this.location = null;
    }

    public boolean wantsSidebar(){
        return this.sidebar;
    }

    public void setSidebar(boolean sidebar){
        this.sidebar = sidebar;
        SimpleFactions.getInstance().getMySql().execute("UPDATE FactionPlayers SET sidebar=? WHERE uuid=?;", sidebar, this.uuid.toString());
        if(!this.getBukkitOfflinePlayer().isOnline()) return;
        Scoreboard scoreboard = this.getBukkitPlayer().getScoreboard();
        if(!sidebar) Bukkit.getScheduler().runTaskAsynchronously(SimpleFactions.getInstance(), () -> scoreboard.getPlayers().forEach(scoreboard::resetScores));
        else{ if(scoreboard.getTeam("#sf-player") == null) scoreboard.registerNewTeam("#sf-player"); }
    }

    public void setLocation(Faction faction){
        this.location = faction;
    }

    public Faction getLocation(){
        return this.location;
    }

    public UUID getUUID(){
        return this.uuid;
    }

    public void setPower(int power){
        this.power = power;
        SimpleFactions.getInstance().getMySql().execute("UPDATE FactionPlayers SET power=? WHERE uuid=?;", this.power, this.uuid.toString());
    }

    public int getPower(){
        return this.power;
    }

    public Timestamp getLastseen(){
        return this.lastseen;
    }

    public org.bukkit.entity.Player getBukkitPlayer() {
        org.bukkit.entity.Player player = Bukkit.getPlayer(this.uuid);
        if(player == null)
            Logger.log(Logger.LogLevel.ERROR, "Tried to use Player#getBukkitPlayer without null check, player is not online.");
        return player;
    }

    public OfflinePlayer getBukkitOfflinePlayer() {
        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(this.uuid);
        if(offlinePlayer == null)
            Logger.log(Logger.LogLevel.ERROR, "Tried to use Player#getBukkitOfflinePlayer without null check, player never logged on.");
        return offlinePlayer;
    }
}
