package io.github.droppinganvil.seamlessdiscord.DefaultPlugins;

import io.github.droppinganvil.seamlessdiscord.*;
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

    public void handleCommand(GuildMessageReceivedEvent e) {
        String stripped = e.getMessage().getContentRaw().replace(Configuration.prefix + "unload ", "");
        if (PluginManager.plugins.containsKey(stripped)) {
            PluginManager.unloaded.put(stripped, PluginManager.plugins.get(stripped));
            MessageManager.sendMessage(PluginManager.plugins.remove(stripped).getNiceName() + Configuration.unload_success, MessageType.Embed, e.getChannel(), "Unload Plugin");
        } else {
            MessageManager.sendMessage(Configuration.unload_failure, MessageType.Embed, e.getChannel(), "Unload Plugin");
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
