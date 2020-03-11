package io.github.droppinganvil.seamlessdiscord.Concurrent;

public interface Toggleable {
    void shutdown();
    boolean active();
    String getNiceName();
}
