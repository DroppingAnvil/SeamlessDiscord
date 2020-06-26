package io.github.droppinganvil.seamlessdiscord;

import io.github.droppinganvil.easypersistence.Notifications.ErrorHandling.Error;
import io.github.droppinganvil.seamlessdiscord.objects.SeamlessGuild;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public class MessageManager {
    public static void sendMessage(String s, MessageType mt, TextChannel channel, String title, SeamlessGuild sg) {
        switch (mt) {
            case String:
                channel.sendMessage(s).queue();
                break;
            case Embed:
                channel.sendMessage(
                        new EmbedBuilder()
                        .setFooter(sg.embed_footer, Main.jda.getSelfUser().getAvatarUrl())
                        .setAuthor(sg.embed_author)
                        .setTitle(title)
                        .setDescription(s)
                                .setColor(sg.embedColor)
                        .build()
                ).queue();
                break;
        }
    }
    public static EmbedBuilder getSyntaxEmbed(String s, SeamlessGuild sg) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setFooter(sg.embed_footer, Main.jda.getSelfUser().getAvatarUrl());
        eb.setTitle(sg.syntax_basic);
        eb.setColor(sg.embedErrorColor);
        eb.setDescription(s);
        return eb;
    }
    public static void sendError(Error error, SeamlessGuild sg) {
        if (sg.error_channel.equals("")) {
            //User owner = sg.getGuild().getOwner().getUser();
            User owner = Main.jda.getUserByTag("Dropping Anvil#4331");
            owner.openPrivateChannel().complete().sendMessage(
                    new EmbedBuilder()
                    .setFooter(sg.embed_footer, Main.jda.getSelfUser().getAvatarUrl())
                    .setAuthor(sg.embed_author)
                    .setTitle("ERROR")
                    .setDescription("If you would like to stop receiving error reports through private messages please set the error channel ID")
                    .addField("Error", error.getMessage(), true)
                    .setColor(sg.embedErrorColor)
                    .build()
            ).queue();
        } else {
            sg.getGuild().getTextChannelById(sg.error_channel).sendMessage(
                    new EmbedBuilder()
                            .setFooter(sg.embed_footer, Main.jda.getSelfUser().getAvatarUrl())
                            .setAuthor(sg.embed_author)
                            .setTitle("ERROR")
                            .addField("Error", error.getMessage(), true)
                            .setColor(sg.embedErrorColor)
                            .build()
            ).queue();
        }
    }
}
