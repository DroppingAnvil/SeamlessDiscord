package io.github.droppinganvil.SeamlessWebD.DefaultPlugins;

import io.github.droppinganvil.SeamlessWebD.Configuration;
import io.github.droppinganvil.SeamlessWebD.Plugin;
import io.github.droppinganvil.SeamlessWebD.PluginManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.GenericPrivateMessageEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;

public class Help implements Plugin {
    public String getNiceName() {
        return "Help";
    }

    public String getCommand() {
        return "help";
    }

    public int getArgsMinSize() {
        return 0;
    }

    public int getArgsMaxSize() {
        return 0;
    }

    public boolean botCanUse() {
        return false;
    }

    public String getSyntax() {
        return "help";
    }

    public void handleCommand(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Help");
        for (Plugin p : PluginManager.plugins.values()) {
            eb.addField(p.getNiceName(), Configuration.prefix + p.getSyntax(), true);
        }
        eb.setFooter(Configuration.embed_footer);
        e.getChannel().sendMessage(eb.build()).queue();
    }

    public void handlePrivateMessage(GenericPrivateMessageEvent e) {

    }

    public void handleReact(GenericMessageReactionEvent e) {

    }

    public Permission getPermissionRequired() {
        return null;
    }
}
