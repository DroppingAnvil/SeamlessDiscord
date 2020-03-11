package io.github.droppinganvil.seamlessdiscord;

import net.dv8tion.jda.api.entities.Activity;

import java.util.Arrays;
import java.util.List;

public class Configuration {
    public static String prefix = "-";
    public static String unknown_basic = "Unknown Command";
    public static String unknown_descriptive = "This command does not exist please use -help to get a list of available commands.";
    public static String syntax_basic = "Incorrect Syntax";
    public static String syntax_descriptive = "Incorrect syntax please try: ";
    public static String embed_author = "SeamlessDiscord";
    public static String embed_footer = "SeamlessDiscord, System by Dropping Anvil";
    public static String embed_errors = "true";
    public static String permission_basic = "No Permission";
    public static String permission_descriptive = "You do not have the required permission: ";
    public static String reaction_positive = "✔";
    public static String reaction_enabled = "true";
    public static String unload_success = " has been unloaded successfully.";
    public static String unload_failure = "A plugin with that command could not be located.";
    public static String load_success = " has been loaded successfully.";
    public static String load_failure = "An unloaded plugin with that command could not be located.";
    public static String token = "";
    public static Integer cooldown = 2;
    public static Long status_interval = 10000L;
    public static List<String> status_list = Arrays.asList("Plugin based Discord Bot framework", "WebPlugins coming soon", "github.com/DroppingAnvil/SeamlessDiscord");
    public static Activity.ActivityType status_activity = Activity.ActivityType.WATCHING;
}
