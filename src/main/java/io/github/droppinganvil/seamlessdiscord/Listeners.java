package io.github.droppinganvil.seamlessdiscord;

import io.github.droppinganvil.seamlessdiscord.Concurrent.CooldownTask;
import io.github.droppinganvil.seamlessdiscord.configurations.Configuration;
import io.github.droppinganvil.seamlessdiscord.objects.SeamlessGuild;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.GenericPrivateMessageEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Listeners extends ListenerAdapter {
    @Override
    public void onGenericMessageReaction(@Nonnull GenericMessageReactionEvent event) {
        for (Plugin p : PluginManager.plugins.values()) {
            p.handleReact(event);
        }
    }

    @Override
    public void onGenericPrivateMessage(@Nonnull GenericPrivateMessageEvent event) {
        for (Plugin p : PluginManager.plugins.values()) {
            p.handlePrivateMessage(event);
        }
    }

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        if (Main.inCooldown.contains(event.getAuthor())) return;
        String[] msgArray = event.getMessage().getContentDisplay().split(" ");
        if (msgArray.length != 0) {
            if (!Main.guildMap.containsKey(event.getGuild().getId())) Main.guildMap.put(event.getGuild().getId(), new SeamlessGuild(event.getGuild()));
            SeamlessGuild sg = Main.guildMap.get(event.getGuild().getId());
            if (msgArray[0].contains(sg.prefix)) PluginManager.handleCMD(msgArray, event);
            Main.inCooldown.add(event.getAuthor());
            CooldownTask.cooldownMap.put(event.getAuthor(), System.currentTimeMillis());
        }
    }

    @Override
    public void onGuildJoin(GuildJoinEvent event) {
        Main.guildMap.put(event.getGuild().getId(), new SeamlessGuild(event.getGuild()));
    }
}
