package io.github.droppinganvil.SeamlessWebD;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

public class MessageManager {
    public static void sendMessage(String s, MessageType mt, TextChannel channel, String title) {
        switch (mt) {
            case String:
                channel.sendMessage(s).queue();
                break;
            case Embed:
                channel.sendMessage(
                        new EmbedBuilder()
                        .setFooter(Configuration.embed_footer)
                        .setAuthor(Configuration.embed_author)
                        .setTitle(title)
                        .setDescription(s)
                        .build()
                ).queue();
                break;
        }
    }
    public static EmbedBuilder getSyntaxEmbed(String s) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setFooter(Configuration.embed_footer);
        eb.setTitle(Configuration.syntax_basic);
        eb.setDescription(s);
        return eb;
    }
}
