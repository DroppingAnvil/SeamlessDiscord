package io.github.droppinganvil.seamlessdiscord;

import io.github.droppinganvil.easypersistence.EasyPersistence;
import io.github.droppinganvil.easypersistence.PersistenceUser;
import io.github.droppinganvil.easypersistence.Types.Objects.Register;
import io.github.droppinganvil.seamlessdiscord.Concurrent.CooldownTask;
import io.github.droppinganvil.seamlessdiscord.Concurrent.StatusTask;
import io.github.droppinganvil.seamlessdiscord.DefaultPlugins.*;
import io.github.droppinganvil.seamlessdiscord.configurations.Configuration;
import io.github.droppinganvil.seamlessdiscord.easypersistence.EPColor;
import io.github.droppinganvil.seamlessdiscord.objects.SeamlessGuild;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static PersistenceUser user = new PersistenceUser("SeamlessDiscord");
    public static JDA jda;
    public static String version = "1.3-BETA";
    public static HashSet<User> inCooldown = new HashSet<User>();
    public static HashMap<String, SeamlessGuild> guildMap = new HashMap<>();
    public static void main(String[] args) {
        //Start up persistence
        EasyPersistence.main(null);
        //Load EP Support
        Register.register(new EPColor());
        //Generate configs
        try {
            jda = new JDABuilder(Configuration.token).build();
            jda.addEventListener(new Listeners());
        } catch (LoginException e) {
            e.printStackTrace();
            System.out.print("Could not login please verify token is correct");
            return;
        }
        //Load Guilds
        for (Guild guild : jda.getGuilds()) {
            guildMap.put(guild.getId(), new SeamlessGuild(guild));
        }
        //Register Default Plugins
        PluginManager.registerPlugin(new Help());
        PluginManager.registerPlugin(new Ping());
        PluginManager.registerPlugin(new Plugins());
        PluginManager.registerPlugin(new Echo());
        PluginManager.registerPlugin(new Info());
        PluginManager.registerPlugin(new UnloadPlugin());
        PluginManager.registerPlugin(new Load());
        PluginManager.registerPlugin(new TaskInfo());
        PluginManager.registerPlugin(new Config());
        PluginManager.registerPlugin(new ConfigView());
        //Start cooldown monitor
        new Thread(new CooldownTask()).start();
        new Thread(new StatusTask()).start();
        CooldownTask.setup = true;
    }
}
