package io.github.droppinganvil.seamlessdiscord.DefaultPlugins;

import io.github.droppinganvil.seamlessdiscord.*;
import io.github.droppinganvil.seamlessdiscord.configurations.Configuration;
import io.github.droppinganvil.seamlessdiscord.objects.SeamlessGuild;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.GenericPrivateMessageEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;

public class Load implements Plugin {
    public String getNiceName() {
        return "Load";
    }

    public String getCommand() {
        return "load";
    }

    public int getArgsMinSize() {
        return 1;
    }

    public int getArgsMaxSize() {
        return 1;
    }

    public boolean botCanUse() {
        return false;
    }

    public String getSyntax() {
        return "load <Unloaded Plugin's Command>";
    }

    public void handleCommand(GuildMessageReceivedEvent e, SeamlessGuild sg) {
        String stripped = e.getMessage().getContentRaw().replace(sg.prefix + "load ", "");
        if (PluginManager.unloaded.containsKey(stripped)) {
            PluginManager.plugins.put(stripped, PluginManager.unloaded.get(stripped));
            MessageManager.sendMessage(PluginManager.unloaded.remove(stripped).getNiceName() + sg.load_success, MessageType.Embed, e.getChannel(), "Load Plugin", sg);
        } else {
            MessageManager.sendMessage(sg.load_failure, MessageType.Embed, e.getChannel(), "Load Plugin", sg);
        }
    }

    public void handlePrivateMessage(GenericPrivateMessageEvent e) {

    }

    public void handleReact(GenericMessageReactionEvent e) {

    }

    public void unload() {

    }

    public Permission getPermissionRequired() {
        return null;
    }
}
