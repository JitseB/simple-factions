package net.jitse.simplefactions.factions;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Jitse on 17-7-2017.
 */
public enum ChatChannel {
    PUBLIC("p"), FACTION("f"), ALLIES("a");

    private String alias;

    ChatChannel(String alias){
        this.alias = alias;
    }

    public String getAlias(){
        return this.alias;
    }

    public static Optional<ChatChannel> fromString(String str) {
        return Stream.of(values()).filter(channel -> channel.toString().equalsIgnoreCase(str) || channel.getAlias().equalsIgnoreCase(str)).findFirst();
    }
}
