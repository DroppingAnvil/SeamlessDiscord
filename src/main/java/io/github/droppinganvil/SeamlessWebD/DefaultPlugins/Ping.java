package io.github.droppinganvil.SeamlessWebD.DefaultPlugins;

import io.github.droppinganvil.SeamlessWebD.Configuration;
import io.github.droppinganvil.SeamlessWebD.Plugin;
import io.github.droppinganvil.SeamlessWebD.Start;
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

    public void handleCommand(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setFooter(Configuration.embed_footer);
        eb.setTitle("Ping");
        eb.addField("Gateway", String.valueOf(Start.jda.getGatewayPing()), true);
        e.getMessage().getChannel().sendMessage(eb.build()).queue();
    }

    public void handlePrivateMessage(GenericPrivateMessageEvent e) {

    }

    public void handleReact(GenericMessageReactionEvent e) {

    }

    public Permission getPermissionRequired() {
        return null;
    }
}
