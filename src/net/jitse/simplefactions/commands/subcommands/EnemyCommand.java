package net.jitse.simplefactions.commands.subcommands;

import net.jitse.simplefactions.SimpleFactions;
import net.jitse.simplefactions.commands.SubCommand;
import net.jitse.simplefactions.factions.Faction;
import net.jitse.simplefactions.factions.Member;
import net.jitse.simplefactions.factions.Role;
import net.jitse.simplefactions.managers.Settings;
import net.jitse.simplefactions.utilities.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Jitse on 10-7-2017.
 */
public class EnemyCommand extends SubCommand {

    public EnemyCommand(Role role){
        super(role, "simplefactions.commands.enemy");
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(Chat.format(Settings.PLAYER_ONLY_COMMAND));
            return;
        }
        Player player = (Player) sender;
        Faction faction = SimpleFactions.getInstance().getFactionsManager().getFaction(player);
        if(args.length != 2){
            player.sendMessage(Chat.format(Settings.COMMAND_USAGE_MESSAGE.replace("{syntax}", "/faction enemy <player | faction>")));
            return;
        }
        Faction target = SimpleFactions.getInstance().getFactionsManager().getFaction(args[1]);
        Player targetPlayer = Bukkit.getPlayer(args[1]);
        if(targetPlayer != null && targetPlayer.isOnline()){
            Faction temp = SimpleFactions.getInstance().getFactionsManager().getFaction(targetPlayer);
            if(temp != null) target = temp;
        }
        if(target == null){
            player.sendMessage(Chat.format(Settings.FACTION_NOT_EXISTS.replace("{faction}", args[1])));
            return;
        }
        if(target.equals(faction)){
            player.sendMessage(Chat.format(Settings.INVALID_COMMAND_USAGE));
            return;
        }
        if(faction.getEnemies().contains(target)){
            player.sendMessage(Chat.format(Settings.ALREADY_ENEMIES.replace("{enemy}", target.getName())));
            return;
        }
        faction.setNeutral(target, true, false);
        target.setNeutral(faction, true, false);
        faction.setEnemy(target, true);
        target.setEnemy(faction, true);
        for(Member member : faction.getMembers()){
            if(!member.getBukkitOfflinePlayer().isOnline()) continue;
            member.getBukkitPlayer().sendMessage(Chat.format(Settings.NOW_ENEMIES.replace("{enemy}", target.getName())));
        }
        for(Member member : target.getMembers()){
            if(!member.getBukkitOfflinePlayer().isOnline()) continue;
            member.getBukkitPlayer().sendMessage(Chat.format(Settings.NOW_ENEMIES.replace("{enemy}", faction.getName())));
        }
    }
}
