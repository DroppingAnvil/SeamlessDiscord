package io.github.droppinganvil.seamlessdiscord.DefaultPlugins;

import io.github.droppinganvil.seamlessdiscord.Concurrent.TaskManager;
import io.github.droppinganvil.seamlessdiscord.Concurrent.Toggleable;
import io.github.droppinganvil.seamlessdiscord.configurations.Configuration;
import io.github.droppinganvil.seamlessdiscord.Plugin;
import io.github.droppinganvil.seamlessdiscord.Main;
import io.github.droppinganvil.seamlessdiscord.objects.SeamlessGuild;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.GenericPrivateMessageEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;

public class TaskInfo implements Plugin {
    public String getNiceName() {
        return "Task Info";
    }

    public String getCommand() {
        return "tasks";
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
        return "tasks";
    }

    public void handleCommand(GuildMessageReceivedEvent e, SeamlessGuild sg) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Task Info");
        for (Toggleable toggleable : TaskManager.taskSet) {
            eb.addField(toggleable.getNiceName(), toggleable.active() ? "Active" : "Shutdown", true);
        }
        eb.setFooter(sg.embed_footer, Main.jda.getSelfUser().getAvatarUrl());
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
