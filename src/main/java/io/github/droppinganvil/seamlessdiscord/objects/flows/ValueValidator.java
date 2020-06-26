package io.github.droppinganvil.seamlessdiscord.objects.flows;

public interface ValueValidator {
    Object validate(String s);
    String getString(Object o);
    String getValueTypeNiceName();
}
