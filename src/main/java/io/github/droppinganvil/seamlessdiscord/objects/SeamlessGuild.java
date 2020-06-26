package io.github.droppinganvil.seamlessdiscord.objects;

import io.github.droppinganvil.easypersistence.PersistenceObject;
import io.github.droppinganvil.seamlessdiscord.Main;
import io.github.droppinganvil.seamlessdiscord.configurations.Configuration;
import net.dv8tion.jda.api.entities.Guild;

import java.awt.*;

public class SeamlessGuild extends PersistenceObject {
    private Guild guild;
    public SeamlessGuild(Guild guild) {
        super("Guilds", guild.getId(), Main.user, Configuration.saveCycles, 0);
        setObject(this);
        this.guild = guild;
    }

    //Per guild config
    public Color embedColor = Color.CYAN;
    public Color embedErrorColor = Color.RED;
    public String prefix = "-";
    public String unknown_basic = "Unknown Command";
    public String unknown_descriptive = "This command does not exist please use -help to get a list of available commands.";
    public String syntax_basic = "Incorrect Syntax";
    public String syntax_descriptive = "Incorrect syntax please try: ";
    public String embed_author = "SeamlessDiscord";
    public String embed_footer = "SeamlessDiscord, System by Dropping Anvil";
    public boolean embed_errors = true;
    public String permission_basic = "No Permission";
    public String permission_descriptive = "You do not have the required permission: ";
    public String reaction_positive = "✔";
    public boolean reaction_enabled = true;
    public String unload_success = " has been unloaded successfully.";
    public String unload_failure = "A plugin with that command could not be located.";
    public String load_success = " has been loaded successfully.";
    public String load_failure = "An unloaded plugin with that command could not be located.";
    public String error_channel = "";

    public Guild getGuild() {
        return guild;
    }
}