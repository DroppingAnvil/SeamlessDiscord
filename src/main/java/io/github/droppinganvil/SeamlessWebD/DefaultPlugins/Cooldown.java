package io.github.droppinganvil.SeamlessWebD.DefaultPlugins;

import io.github.droppinganvil.SeamlessWebD.Concurrent.CooldownTask;
import io.github.droppinganvil.SeamlessWebD.Configuration;
import io.github.droppinganvil.SeamlessWebD.Plugin;
import io.github.droppinganvil.SeamlessWebD.Start;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.GenericPrivateMessageEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;

public class Cooldown implements Plugin {
    public String getNiceName() {
        return "Cooldown Info";
    }

    public String getCommand() {
        return "cooldown";
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
        return "cooldown";
    }

    public void handleCommand(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Cooldown Info");
        eb.addField("Users in Cooldown", String.valueOf(Start.inCooldown.size()), true);
        eb.addField("Cooldown Task Size", String.valueOf(CooldownTask.cooldownMap.size()), true);
        eb.setFooter(Configuration.embed_footer, Start.jda.getSelfUser().getAvatarUrl());
        e.getMessage().getChannel().sendMessage(eb.build()).queue();
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
