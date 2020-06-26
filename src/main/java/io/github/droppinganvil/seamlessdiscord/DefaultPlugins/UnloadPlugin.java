package io.github.droppinganvil.seamlessdiscord.DefaultPlugins;

import io.github.droppinganvil.seamlessdiscord.*;
import io.github.droppinganvil.seamlessdiscord.configurations.Configuration;
import io.github.droppinganvil.seamlessdiscord.objects.SeamlessGuild;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.GenericPrivateMessageEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;

public class UnloadPlugin implements Plugin {
    public String getNiceName() {
        return "Unload Plugin";
    }

    public String getCommand() {
        return "unload";
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
        return "unload <Command>";
    }

    public void handleCommand(GuildMessageReceivedEvent e, SeamlessGuild sg) {
        String stripped = e.getMessage().getContentRaw().replace(sg.prefix + "unload ", "");
        if (PluginManager.plugins.containsKey(stripped)) {
            PluginManager.unloaded.put(stripped, PluginManager.plugins.get(stripped));
            MessageManager.sendMessage(PluginManager.plugins.remove(stripped).getNiceName() + sg.unload_success, MessageType.Embed, e.getChannel(), "Unload Plugin", sg);
        } else {
            MessageManager.sendMessage(sg.unload_failure, MessageType.Embed, e.getChannel(), "Unload Plugin", sg);
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
