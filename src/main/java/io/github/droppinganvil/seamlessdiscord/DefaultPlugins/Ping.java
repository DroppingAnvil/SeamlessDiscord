package io.github.droppinganvil.seamlessdiscord.DefaultPlugins;

import io.github.droppinganvil.seamlessdiscord.Plugin;
import io.github.droppinganvil.seamlessdiscord.Main;
import io.github.droppinganvil.seamlessdiscord.objects.SeamlessGuild;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.GenericPrivateMessageEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;

public class Ping implements Plugin {
    public String getNiceName() {
        return "Ping";
    }

    public String getCommand() {
        return "ping";
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
        return "ping";
    }

    public void handleCommand(GuildMessageReceivedEvent e, SeamlessGuild sg) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setFooter(sg.embed_footer);
        eb.setTitle("Ping");
        eb.addField("Gateway", String.valueOf(Main.jda.getGatewayPing()), true);
        e.getMessage().getChannel().sendMessage(eb.build()).queue();
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
