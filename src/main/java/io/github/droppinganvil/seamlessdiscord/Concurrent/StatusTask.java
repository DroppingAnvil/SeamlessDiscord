package io.github.droppinganvil.seamlessdiscord.Concurrent;

import io.github.droppinganvil.seamlessdiscord.Configuration;
import io.github.droppinganvil.seamlessdiscord.Start;
import net.dv8tion.jda.api.entities.Activity;

public class StatusTask implements Runnable, Toggleable {
    public static Boolean enabled = true;
    public StatusTask() {
        TaskManager.taskSet.add(this);
    }
    public void run() {
        while (enabled) {
            for (String status : Configuration.status_list) {
                Start.jda.getPresence().setPresence(Activity.of(Configuration.status_activity, status), true);
                try {
                    Thread.sleep(Configuration.status_interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void shutdown() {
        enabled = false;
    }

    @Override
    public boolean active() {
        return enabled;
    }

    @Override
    public String getNiceName() {
        return "Status Task";
    }
}
