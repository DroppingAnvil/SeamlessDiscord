package io.github.droppinganvil.seamlessdiscord.objects.flows;

import net.dv8tion.jda.api.entities.Member;

import java.util.HashMap;

public class TextFlow {
    public String name;
    public Integer index;
    public HashMap<Integer, TextFlowEntry> entryMap = new HashMap<>();
    public Member m;

    public void addEntry(Integer i, TextFlowEntry tfe) {
        entryMap.put(i, tfe);
    }

    public boolean setResponse(Integer key, String value) {
        return entryMap.get(key).setValue(value);
    }

    public boolean setResponse(String value) {
        if (entryMap.get(index).setValue(value)) {
            index++;
            return true;
        }
        return false;
    }

    public Object getValue(Integer key) {
        return entryMap.get(key).value;
    }
}
