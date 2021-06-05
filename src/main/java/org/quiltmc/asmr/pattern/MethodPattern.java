package org.quiltmc.asmr.pattern;

public class MethodPattern extends SliceEntryPattern<MethodPattern> {
    protected MethodPattern(AbstractPattern<?> parent) {
        super(parent);
    }

    @Override
    protected MethodPattern create(AbstractPattern<?> parent) {
        return new MethodPattern(parent);
    }

    public ValuePattern<String> name() {
        return new ValuePattern<>("name", this);
    }

    public MethodBodyPattern body() {
        return new MethodBodyPattern(this);
    }

    public AbstractInstructionPattern<?> instructions() {
        return this.body().instructions();
    }
}
