package io.github.droppinganvil.SeamlessWebD;

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
        String[] msgArray = event.getMessage().getContentDisplay().split(" ");
        if (msgArray.length != 0) {
            if (msgArray[0].contains(Configuration.prefix)) PluginManager.handleCMD(msgArray, event);
        }
    }
}
