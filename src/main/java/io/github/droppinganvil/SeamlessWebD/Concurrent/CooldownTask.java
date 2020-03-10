package io.github.droppinganvil.SeamlessWebD.Concurrent;

import io.github.droppinganvil.SeamlessWebD.Configuration;
import io.github.droppinganvil.SeamlessWebD.Start;
import net.dv8tion.jda.api.entities.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CooldownTask implements Runnable {
    public static ConcurrentHashMap<User, Long> cooldownMap = new ConcurrentHashMap<User, Long>();
    public static boolean enabled = true;
    public static boolean setup = false;
    public void run() {
        while (enabled) {
            for (Map.Entry<User, Long> entry : cooldownMap.entrySet()) {
                if ((System.currentTimeMillis() - entry.getValue()) / 1000 >= Configuration.cooldown) {
                    Start.inCooldown.remove(entry.getKey());
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
}
