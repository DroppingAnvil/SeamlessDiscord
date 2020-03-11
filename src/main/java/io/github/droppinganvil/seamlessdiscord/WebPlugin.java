package io.github.droppinganvil.seamlessdiscord;

import net.dv8tion.jda.api.entities.User;

import java.net.URL;

public interface WebPlugin extends Plugin {
    URL getCoverImage();
    WebPluginResponse process(User user);
    String getWebNiceName();
}
