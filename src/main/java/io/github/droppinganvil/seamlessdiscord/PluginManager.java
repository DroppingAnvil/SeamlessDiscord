package io.github.droppinganvil.seamlessdiscord;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import java.util.concurrent.ConcurrentHashMap;

public class PluginManager {
    public static final boolean embed_errors = Configuration.embed_errors.equals("true");
    public static ConcurrentHashMap<String, Plugin> plugins = new ConcurrentHashMap<String, Plugin>();
    public static ConcurrentHashMap<String, Plugin> unloaded = new ConcurrentHashMap<String, Plugin>();
    public static ConcurrentHashMap<String, WebPlugin> webPlugins = new ConcurrentHashMap<String, WebPlugin>();
    public static void handleCMD(String[] cmd, GuildMessageReceivedEvent event) {
        String actual = cmd[0].replace(Configuration.prefix, "").toLowerCase();
        if (!plugins.containsKey(actual)) {
            MessageManager.sendMessage(Configuration.unknown_descriptive, embed_errors ? MessageType.Embed : MessageType.String, event.getChannel(), Configuration.unknown_basic);
            return;
        }
        Plugin target = plugins.get(actual);
        // -1 to account for the command
        int size = cmd.length - 1;
        if (target.getArgsMaxSize() < size || target.getArgsMinSize() > size) {
            MessageManager.sendMessage(Configuration.syntax_descriptive + Configuration.prefix + target.getSyntax(), embed_errors ? MessageType.Embed : MessageType.String, event.getChannel(), Configuration.syntax_basic);
            return;
        }
        if (event.getAuthor().isBot() && !target.botCanUse()) return;
        if (target.getPermissionRequired() != null) {
            if (!event.getMember().hasPermission(target.getPermissionRequired())) {
                MessageManager.sendMessage(Configuration.permission_descriptive + target.getPermissionRequired().getName(), embed_errors ? MessageType.Embed : MessageType.String, event.getChannel(), Configuration.permission_basic);
                return;
            }
        }
        event.getMessage().addReaction(Configuration.reaction_positive).queue();
        target.handleCommand(event);
    }
    public static void registerPlugin(Plugin p) {
        plugins.put(p.getCommand(), p);
    }
    public static void registerPlugin(WebPlugin p) {
        plugins.put(p.getCommand(), p);
        webPlugins.put(p.getWebNiceName(), p);
    }
}
