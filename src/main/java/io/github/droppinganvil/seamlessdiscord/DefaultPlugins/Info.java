package io.github.droppinganvil.seamlessdiscord.DefaultPlugins;

import io.github.droppinganvil.seamlessdiscord.configurations.Configuration;
import io.github.droppinganvil.seamlessdiscord.Plugin;
import io.github.droppinganvil.seamlessdiscord.Main;
import io.github.droppinganvil.seamlessdiscord.objects.SeamlessGuild;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.GenericPrivateMessageEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;

public class Info implements Plugin {

    public String getNiceName() {
        return "Info";
    }

    public String getCommand() {
        return "info";
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
        return "info";
    }

    public void handleCommand(GuildMessageReceivedEvent e, SeamlessGuild sg) {
        e.getMessage().getChannel().sendMessage(
                new EmbedBuilder()
                .setTitle("Info")
                .addField("Author", "Dropping Anvil", true)
                        .addField("Version", Main.version, true)
                        .addField("Project", "https://github.com/DroppingAnvil/SeamlessDiscord", false)
                        .addField("License", "https://github.com/DroppingAnvil/SeamlessDiscord/blob/master/LICENSE", false)
                        .setFooter(sg.embed_footer, Main.jda.getSelfUser().getAvatarUrl())
                .build()
        ).queue();
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
