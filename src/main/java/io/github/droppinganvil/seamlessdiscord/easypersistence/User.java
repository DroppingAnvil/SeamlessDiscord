package io.github.droppinganvil.seamlessdiscord.easypersistence;

import io.github.droppinganvil.easypersistence.Notifications.ErrorHandling.Error;
import io.github.droppinganvil.easypersistence.Notifications.ErrorHandling.ExtraErrorData;
import io.github.droppinganvil.easypersistence.PersistenceUser;
import io.github.droppinganvil.seamlessdiscord.MessageManager;
import io.github.droppinganvil.seamlessdiscord.objects.SeamlessGuild;

public class User extends PersistenceUser {
    private static User instance;
    public static User getInstance() {
        return instance;
    }
    public User() {
        super("SeamlessDiscord");
        instance = this;
    }
    @Override
    public void handleLocalError(Error error) {
        System.out.print(error.getMessage());
        System.out.print(error.getObject().getClass());
        if (error.hasFlag(ExtraErrorData.Object) && error.hasFlag(ExtraErrorData.Message)) {
            if (error.getObject() instanceof SeamlessGuild) {
                MessageManager.sendError(error, (SeamlessGuild) error.getObject());
            }
        }
    }
    public void handleGlobalError(Error error) {
        System.out.print(error.getMessage());
    }
}
