package io.github.droppinganvil.seamlessdiscord.configurations;

import io.github.droppinganvil.easypersistence.PersistenceObject;
import io.github.droppinganvil.easypersistence.PersistenceUser;
import io.github.droppinganvil.seamlessdiscord.Main;
import net.dv8tion.jda.api.entities.Activity;

import java.util.Arrays;
import java.util.List;

public class Configuration extends PersistenceObject {
    public static String token = "Njg2NzQ4NzMzMzk2MDkwOTIz.XvVlyA.qsziYeZliuQKyug7FvjfCm8Vbro";
    public static Integer cooldown = 2;
    public static Long status_interval = 10000L;
    public static List<String> status_list = Arrays.asList("Plugin based Discord Bot framework", "WebPlugins coming soon", "github.com/DroppingAnvil/SeamlessDiscord");
    public static Activity.ActivityType status_activity = Activity.ActivityType.WATCHING;
    public static Integer saveCycles = 300;

    public Configuration() {
        super("Configurations", "Config", Main.user, 1000, 0);
        setObject(this);
    }
}
