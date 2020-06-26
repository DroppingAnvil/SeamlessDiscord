package io.github.droppinganvil.seamlessdiscord;

import io.github.droppinganvil.seamlessdiscord.objects.SeamlessGuild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import java.util.concurrent.ConcurrentHashMap;

public class PluginManager {
    public static ConcurrentHashMap<String, Plugin> plugins = new ConcurrentHashMap<String, Plugin>();
    public static ConcurrentHashMap<String, Plugin> unloaded = new ConcurrentHashMap<String, Plugin>();
    public static ConcurrentHashMap<String, WebPlugin> webPlugins = new ConcurrentHashMap<String, WebPlugin>();
    public static void handleCMD(String[] cmd, GuildMessageReceivedEvent event) {
        SeamlessGuild sg = Main.guildMap.get(event.getGuild().getId());
        String actual = cmd[0].replace(sg.prefix, "").toLowerCase();
        if (!plugins.containsKey(actual)) {
            MessageManager.sendMessage(sg.unknown_descriptive, sg.embed_errors ? MessageType.Embed : MessageType.String, event.getChannel(), sg.unknown_basic, sg);
            return;
        }
        Plugin target = plugins.get(actual);
        // -1 to account for the command
        int size = cmd.length - 1;
        if (target.getArgsMaxSize() < size || target.getArgsMinSize() > size) {
            MessageManager.sendMessage(sg.syntax_descriptive + sg.prefix + target.getSyntax(), sg.embed_errors ? MessageType.Embed : MessageType.String, event.getChannel(), sg.syntax_basic, sg);
            return;
        }
        if (event.getAuthor().isBot() && !target.botCanUse()) return;
        if (target.getPermissionRequired() != null) {
            if (!event.getMember().hasPermission(target.getPermissionRequired())) {
                MessageManager.sendMessage(sg.permission_descriptive + target.getPermissionRequired().getName(), sg.embed_errors ? MessageType.Embed : MessageType.String, event.getChannel(), sg.permission_basic, sg);
                return;
            }
        }
        event.getMessage().addReaction(sg.reaction_positive).queue();
        target.handleCommand(event, sg);
    }
    public static void registerPlugin(Plugin p) {
        plugins.put(p.getCommand(), p);
    }
    public static void registerPlugin(WebPlugin p) {
        plugins.put(p.getCommand(), p);
        webPlugins.put(p.getWebNiceName(), p);
    }
}
