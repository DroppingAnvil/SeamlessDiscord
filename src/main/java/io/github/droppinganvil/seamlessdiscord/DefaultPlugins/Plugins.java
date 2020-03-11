package io.github.droppinganvil.seamlessdiscord.DefaultPlugins;

import io.github.droppinganvil.seamlessdiscord.*;
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
        eb.setFooter(Configuration.embed_footer, Start.jda.getSelfUser().getAvatarUrl());
        eb.addField("Total Plugins", String.valueOf(PluginManager.plugins.size() + PluginManager.unloaded.size()), true);
        eb.addField("Enabled/Disabled Plugins", PluginManager.plugins.size() + "/" + PluginManager.unloaded.size(), true);
        StringBuilder sb = new StringBuilder();
        for (Plugin p : PluginManager.plugins.values()) {
            sb.append(p.getNiceName());
            sb.append(", ");
        }
        eb.addField("Plugins Loaded", sb.toString(), false);
        StringBuilder sbb = new StringBuilder();
        for (Plugin p : PluginManager.unloaded.values()) {
            sbb.append(p.getNiceName());
            sbb.append(", ");
        }
        eb.addField("Plugins Unloaded", sbb.toString(), false);
        StringBuilder websb = new StringBuilder();
        for (WebPlugin p : PluginManager.webPlugins.values()) {
            websb.append(p.getNiceName());
            websb.append(", ");
        }
        eb.addField("WebPlugins Loaded", websb.toString(), false);
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
