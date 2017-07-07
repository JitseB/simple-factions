package net.jitse.simplefactions.managers;

/**
 * Created by Jitse on 23-6-2017.
 */
public class Settings {

    public static final String COMMAND_PREFIX = "&7[&cDecimate&fPVP&7]&f ";
    public static final String SERVER_NAME = "&c&lD&6&lE&e&lC&a&lI&b&lM&9&lA&5&lT&c&lE &f&lPVP&r";
    public static final int PLAYER_MAX_POWER = 100;
    public static final int MAX_LINE_CLAIM = 5;

    public static final String FACTION_DISBAND = "&fFaction &c&o{faction}&r &fhas been disbanned by &7&o{by}&r&f.";
    public static final String CLAIMED_LINE_OF_CHUNKS = "&aYou claimed &7&o{amount}&r&a chunks in your current facing direction (&7&o{pole}&r&a).";
    public static final String NOW_IN = "&8Now in &c&o{land}&r&8.";
    public static final String ENTERING_LAND = "&8Now entering &c&o{land}&r&8.";
    public static final String WILDERNESS_NAME = "&r&a&oWilderness";
    public static final String CHUNK_ALREADY_CLAIMED = "&cThis land has already been claimed by &7&o{faction}&r&c.";
    public static final String CLAIMED_CHUNK = "&aSuccessfully claimed land! &fYou can now start building on it.";
    public static final String FACTION_ALREADY_EXISTS = "&cFaction &f&o{name} &r&calready exists, please choose a different name for your faction.";
    public static final String FACTION_NAME_TOO_LONG = "&cThe given faction name is too long, please choose one with a maximum of 14 characters.";
    public static final String SUCCESS_FULLY_RESET_SYSTEM = "&aSystem has been reset successfully.";
    public static final String SYSTEM_RESET_KICK = "&cResetting all factions...&r\n&cPlease check back later for our new season!";
    public static final String FATAL_LOAD_KICK = "&cSomething went wrong while loading your profile.";
    public static final String COMMAND_USAGE_MESSAGE = "&cUsage: &f{syntax}";
    public static final String INVALID_COMMAND_USAGE = "&cInvalid command usage.";
    public static final String PLAYER_ONLY_COMMAND = "&cSorry, but this command can only be used by players.";
    public static final String ALREADY_IN_FACTION = "&cYou can only use this command when you're not already in one. Use &e&o/faction leave &r&cto remove yourself.";
    public static final String NOT_IN_FACTION = "&cYou can only use this command when you're in a faction.";
    public static final String LOADING_KICK_MESSAGE = "&cServer is still loading all factions...";
    public static final String CREATED_FACTION_BROADCAST = "&7&o{player} &r&fcreated faction &c&o{faction}&r&f.";
    public static final String NO_PERMISSION_COMMAND = "&fSeems like you don't have permission to execute this command, you need to have access to &7&o{permission}&f.";
    public static final String NO_ROLE_PERMISSION_COMMAND = "&fSeems like you don't have the correct role for this command, you need to be at least &7&o{role}&f.";
}
