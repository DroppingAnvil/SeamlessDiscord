package io.github.droppinganvil.seamlessdiscord.DefaultPlugins;

import io.github.droppinganvil.easypersistence.Types.TypeAdapter;
import io.github.droppinganvil.easypersistence.Types.YAML.YAMLAdapter;
import io.github.droppinganvil.seamlessdiscord.Plugin;
import io.github.droppinganvil.seamlessdiscord.easypersistence.User;
import io.github.droppinganvil.seamlessdiscord.objects.SeamlessGuild;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.GenericPrivateMessageEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ConfigView implements Plugin {

    @Override
    public String getNiceName() {
        return "Config View";
    }

    @Override
    public String getCommand() {
        return "configview";
    }

    @Override
    public int getArgsMinSize() {
        return 0;
    }

    @Override
    public int getArgsMaxSize() {
        return 0;
    }

    @Override
    public boolean botCanUse() {
        return false;
    }

    @Override
    public String getSyntax() {
        return "configview";
    }

    @Override
    public void handleCommand(GuildMessageReceivedEvent e, SeamlessGuild sg) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Guild Configuration");
        eb.setColor(sg.embedColor);
        eb.setAuthor(sg.embed_author);
        eb.setFooter(sg.embed_footer);
        try {
            for (Field f : sg.getClass().getDeclaredFields()) {
                int mod = f.getModifiers();
                //TODO Fix EPColor not working so that getSaveData will not throw
                //if (Modifier.isPublic(mod)) eb.addField(f.getName(), (String) ((YAMLAdapter) User.getInstance().getAdapter()).getSaveData(f.get(sg), f), true);
                if (Modifier.isPublic(mod)) eb.addField(f.getName(), f.get(sg).toString(), true);
            }
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        e.getChannel().sendMessage(eb.build()).queue();
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
