package org.quiltmc.asmr.pattern;

public class MethodPattern extends SliceEntryPattern<MethodPattern> {
    protected MethodPattern(Pattern<?> parent) {
        super(parent);
    }

    @Override
    protected MethodPattern create(Pattern<?> parent) {
        return new MethodPattern(parent);
    }

    public ValuePattern<String> name() {
        return new ValuePattern<>("name", this);
    }

    public MethodBodyPattern body() {
        return new MethodBodyPattern(this);
    }
}
