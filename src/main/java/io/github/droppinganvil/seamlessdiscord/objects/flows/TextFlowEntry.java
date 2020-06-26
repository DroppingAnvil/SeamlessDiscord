package io.github.droppinganvil.seamlessdiscord.objects.flows;

public class TextFlowEntry {
    public String field;
    public Object value;
    public String instructions;
    public ValueValidator validator;

    public TextFlowEntry(String name, String instructions) {
        field = name;
        this.instructions = instructions;
    }

    public boolean setValue(String s) {
        if (validator == null) {
            value = s;
        } else {
            Object parsed = validator.validate(s);
            if (parsed == null) return false;
            value = parsed;
        }
        return true;
    }
}
