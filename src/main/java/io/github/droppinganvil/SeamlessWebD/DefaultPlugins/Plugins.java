package io.github.droppinganvil.SeamlessWebD.DefaultPlugins;

import io.github.droppinganvil.SeamlessWebD.Configuration;
import io.github.droppinganvil.SeamlessWebD.Plugin;
import io.github.droppinganvil.SeamlessWebD.PluginManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.GenericPrivateMessageEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;

public class Plugins implements Plugin {
    public String getNiceName() {
        return "Plugins";
    }

    public String getCommand() {
        return "plugins";
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
        return "plugins";
    }

    public void handleCommand(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Plugin Information");
        eb.setFooter(Configuration.embed_footer);
        eb.addField("Plugins Registered", String.valueOf(PluginManager.plugins.size()), true);
        StringBuilder sb = new StringBuilder();
        for (Plugin p : PluginManager.plugins.values()) {
            sb.append(p.getNiceName());
            sb.append(", ");
        }
        eb.addField("Plugins", sb.toString(), true);
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
