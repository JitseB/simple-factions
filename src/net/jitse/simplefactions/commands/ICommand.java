package net.jitse.simplefactions.commands;

import org.bukkit.command.CommandSender;

/**
 * Created by Jitse on 25-6-2017.
 */
public interface ICommand {

    void perform(CommandSender sender, String[] args);
}
