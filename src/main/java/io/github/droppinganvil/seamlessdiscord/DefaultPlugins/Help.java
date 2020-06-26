package io.github.droppinganvil.seamlessdiscord.DefaultPlugins;

import io.github.droppinganvil.seamlessdiscord.Plugin;
import io.github.droppinganvil.seamlessdiscord.PluginManager;
import io.github.droppinganvil.seamlessdiscord.Main;
import io.github.droppinganvil.seamlessdiscord.objects.SeamlessGuild;
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

    public void handleCommand(GuildMessageReceivedEvent e, SeamlessGuild sg) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Help");
        for (Plugin p : PluginManager.plugins.values()) {
            eb.addField(p.getNiceName(), sg.prefix + p.getSyntax(), true);
        }
        eb.setFooter(sg.embed_footer, Main.jda.getSelfUser().getAvatarUrl());
        e.getChannel().sendMessage(eb.build()).queue();
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
