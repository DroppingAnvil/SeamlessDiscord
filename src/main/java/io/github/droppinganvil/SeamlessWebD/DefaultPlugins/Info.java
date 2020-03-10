package io.github.droppinganvil.SeamlessWebD.DefaultPlugins;

import io.github.droppinganvil.SeamlessWebD.Configuration;
import io.github.droppinganvil.SeamlessWebD.Plugin;
import io.github.droppinganvil.SeamlessWebD.Start;
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

    public void handleCommand(GuildMessageReceivedEvent e) {
        e.getMessage().getChannel().sendMessage(
                new EmbedBuilder()
                .setTitle("Info")
                .addField("Author", "Dropping Anvil", true)
                        .addField("Version", Start.version, true)
                        .addField("Project", "https://github.com/DroppingAnvil/SeamlessDiscord", false)
                        .addField("License", "https://github.com/DroppingAnvil/SeamlessDiscord/blob/master/LICENSE", false)
                        .setFooter(Configuration.embed_footer, Start.jda.getSelfUser().getAvatarUrl())
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
