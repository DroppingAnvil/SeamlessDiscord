package io.github.droppinganvil.seamlessdiscord;

import io.github.droppinganvil.seamlessdiscord.Concurrent.CooldownTask;
import io.github.droppinganvil.seamlessdiscord.Concurrent.StatusTask;
import io.github.droppinganvil.seamlessdiscord.DefaultPlugins.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.User;

import javax.security.auth.login.LoginException;
import java.util.HashSet;

public class Start {
    public static JDA jda;
    public static String version = "1.1-BETA";
    public static HashSet<User> inCooldown = new HashSet<User>();
    public static void main(String[] args) {
        //Generate configs
        try {
            jda = new JDABuilder(Configuration.token).build();
            jda.addEventListener(new Listeners());
        } catch (LoginException e) {
            e.printStackTrace();
            System.out.print("Could not login please verify token is correct");
            return;
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
        //Start cooldown monitor
        new Thread(new CooldownTask()).start();
        new Thread(new StatusTask()).start();
        CooldownTask.setup = true;
    }
}
