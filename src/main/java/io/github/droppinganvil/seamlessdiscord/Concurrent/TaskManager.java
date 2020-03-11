package io.github.droppinganvil.seamlessdiscord.Concurrent;

import java.util.HashSet;

public class TaskManager {
    public static HashSet<Toggleable> taskSet = new HashSet<>();
    public static void shutdown() {
        taskSet.forEach(Toggleable::shutdown);
    }
}
