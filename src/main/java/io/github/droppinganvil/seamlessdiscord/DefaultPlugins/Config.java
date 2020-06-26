package io.github.droppinganvil.seamlessdiscord.DefaultPlugins;

import io.github.droppinganvil.seamlessdiscord.Main;
import io.github.droppinganvil.seamlessdiscord.Plugin;
import io.github.droppinganvil.seamlessdiscord.objects.SeamlessGuild;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.GenericPrivateMessageEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;

public class Config implements Plugin {
    @Override
    public String getNiceName() {
        return "Config";
    }

    @Override
    public String getCommand() {
        return "config";
    }

    @Override
    public int getArgsMinSize() {
        return 2;
    }

    @Override
    public int getArgsMaxSize() {
        return 50;
    }

    @Override
    public boolean botCanUse() {
        return false;
    }

    @Override
    public String getSyntax() {
        return "config <Value Name> <Value>";
    }

    @Override
    public void handleCommand(GuildMessageReceivedEvent e, SeamlessGuild sg) {
        String[] tempArray = e.getMessage().getContentRaw().split(" ");
        String field = tempArray[1];
        String value = e.getMessage().getContentRaw()
                .replace(sg.prefix + "config ", "")
                .replace(field + " ", "");
        sg.getRemoteEdits().put(field, value);
        Main.user.getAdapter().loadEdits(sg);
    }

    @Override
    public void handlePrivateMessage(GenericPrivateMessageEvent e) {

    }

    @Override
    public void handleReact(GenericMessageReactionEvent e) {

    }

    @Override
    public void unload() {

    }

    @Override
    public Permission getPermissionRequired() {
        return Permission.ADMINISTRATOR;
    }
}
