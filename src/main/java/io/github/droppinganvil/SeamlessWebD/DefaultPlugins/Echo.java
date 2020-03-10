package io.github.droppinganvil.SeamlessWebD.DefaultPlugins;

import io.github.droppinganvil.SeamlessWebD.Configuration;
import io.github.droppinganvil.SeamlessWebD.MessageManager;
import io.github.droppinganvil.SeamlessWebD.Plugin;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
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
        return 3;
    }

    public int getArgsMaxSize() {
        return 3;
    }

    public boolean botCanUse() {
        return false;
    }

    public String getSyntax() {
        return "echo <Message> <Amount>";
    }

    public Permission getPermissionRequired() {
        return Permission.ADMINISTRATOR;
    }

    public void handleCommand(GuildMessageReceivedEvent e) {
        String[] command = e.getMessage().getContentDisplay().split(" ");
        int i = 0;
        try {
            i = Integer.parseInt(command[2]);
        } catch (NumberFormatException ex) {
            e.getMessage().getChannel().sendMessage(MessageManager.getSyntaxEmbed("Argument 2 must be an Integer!").build()).queue();
            return;
        }
        if (i > 10) {
            e.getMessage().getChannel().sendMessage(MessageManager.getSyntaxEmbed("Echo is not allowed over 10 times.").build()).queue();
            return;
        }
        while (i != 0) {
            e.getMessage().getChannel().sendMessage(command[1]).queue();
            i--;
        }
    }

    public void handlePrivateMessage(GenericPrivateMessageEvent e) {

    }

    public void handleReact(GenericMessageReactionEvent e) {

    }
}
