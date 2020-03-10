package io.github.droppinganvil.SeamlessWebD;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.GenericPrivateMessageEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;
//Should be one plugin per function
public interface Plugin {
    String getNiceName();
    String getCommand();
    int getArgsMinSize();
    int getArgsMaxSize();
    boolean botCanUse();
    String getSyntax();
    void handleCommand(GuildMessageReceivedEvent e);
    void handlePrivateMessage(GenericPrivateMessageEvent e);
    void handleReact(GenericMessageReactionEvent e);
    Permission getPermissionRequired();
}
