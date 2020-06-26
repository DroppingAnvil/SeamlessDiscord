package io.github.droppinganvil.seamlessdiscord.easypersistence;

import io.github.droppinganvil.easypersistence.Types.Objects.Buildable;

import java.awt.*;

public class EPColor implements Buildable {
    @Override
    public Class<?> getObjectClass() {
        return java.awt.Color.class;
    }

    @Override
    public String getSaveData(Object o) {
        Color c = (Color) o;
        return c.getRed() + " " + c.getGreen() + " " + c.getBlue();
    }

    @Override
    public Object build(String s) {
        String[] colorSplit = s.split(" ");
        return new Color(Integer.parseInt(colorSplit[0]), Integer.parseInt(colorSplit[1]), Integer.parseInt(colorSplit[2]));
    }
}
