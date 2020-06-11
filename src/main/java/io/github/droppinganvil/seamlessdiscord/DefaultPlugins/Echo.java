package io.github.droppinganvil.seamlessdiscord.DefaultPlugins;

import io.github.droppinganvil.seamlessdiscord.Configuration;
import io.github.droppinganvil.seamlessdiscord.Plugin;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.GenericPrivateMessageEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;

public class Echo implements Plugin {
    public String getNiceName() {
        return "Echo";
    }

    public String getCommand() {
        return "echo";
    }

    public int getArgsMinSize() {
        return 2;
    }

    public int getArgsMaxSize() {
        return 100;
    }

    public boolean botCanUse() {
        return false;
    }

    public String getSyntax() {
        return "echo <integer> [string]";
    }

    public void handleCommand(GuildMessageReceivedEvent e) {
        TextChannel tc = e.getChannel();
        String temp = e.getMessage().getContentRaw();
        Integer x;
        try {
            x = Integer.parseInt(temp.split(" ")[1]);
        } catch (Exception ex) {
            tc.sendMessage(temp.split(" ")[1] + "is not a valid integer!");
            return;
        }
        temp = temp
                .replace(x.toString(), "")
                .replace(Configuration.prefix + "echo", "");
        while (x != 0) {
            tc.sendMessage(temp).queue();
            x--;
        }


    }

    public void handlePrivateMessage(GenericPrivateMessageEvent e) {

    }

    public void handleReact(GenericMessageReactionEvent e) {

    }

    public void unload() {

    }

    public Permission getPermissionRequired() {
        return Permission.ADMINISTRATOR;
    }
}
