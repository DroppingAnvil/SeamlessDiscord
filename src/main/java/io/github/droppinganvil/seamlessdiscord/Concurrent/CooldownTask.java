package io.github.droppinganvil.seamlessdiscord.Concurrent;

import io.github.droppinganvil.seamlessdiscord.configurations.Configuration;
import io.github.droppinganvil.seamlessdiscord.Main;
import net.dv8tion.jda.api.entities.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CooldownTask implements Runnable, Toggleable{
    public static ConcurrentHashMap<User, Long> cooldownMap = new ConcurrentHashMap<User, Long>();
    public static boolean enabled = true;
    public static boolean setup = false;
    public CooldownTask() {
        TaskManager.taskSet.add(this);
    }
    public void run() {
        while (enabled) {
            for (Map.Entry<User, Long> entry : cooldownMap.entrySet()) {
                if ((System.currentTimeMillis() - entry.getValue()) / 1000 >= Configuration.cooldown) {
                    Main.inCooldown.remove(entry.getKey());
                    cooldownMap.remove(entry.getKey());
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void shutdown() {
        enabled = false;
    }

    @Override
    public boolean active() {
        return enabled;
    }

    @Override
    public String getNiceName() {
        return "Cooldown Task";
    }
}
