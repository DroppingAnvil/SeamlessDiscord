package io.github.droppinganvil.SeamlessWebD.DefaultPlugins;

import io.github.droppinganvil.SeamlessWebD.*;
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

    public void handleCommand(GuildMessageReceivedEvent e) {
        String stripped = e.getMessage().getContentRaw().replace(Configuration.prefix + "load ", "");
        if (PluginManager.unloaded.containsKey(stripped)) {
            PluginManager.plugins.put(stripped, PluginManager.unloaded.get(stripped));
            MessageManager.sendMessage(PluginManager.unloaded.remove(stripped).getNiceName() + Configuration.load_success, MessageType.Embed, e.getChannel(), "Load Plugin");
        } else {
            MessageManager.sendMessage(Configuration.load_failure, MessageType.Embed, e.getChannel(), "Load Plugin");
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
