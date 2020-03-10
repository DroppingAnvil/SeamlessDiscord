package io.github.droppinganvil.SeamlessWebD;

import io.github.droppinganvil.SeamlessWebD.DefaultPlugins.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Start {
    public static JDA jda;
    public static String version = "1.0-BETA";
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

    }
}
