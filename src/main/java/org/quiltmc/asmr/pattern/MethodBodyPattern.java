package org.quiltmc.asmr.pattern;

public class MethodBodyPattern extends Pattern<MethodBodyPattern> {
    protected MethodBodyPattern(Pattern<?> parent) {
        super(parent);
    }

    @Override
    protected MethodBodyPattern create(Pattern<?> parent) {
        return new MethodBodyPattern(parent);
    }

    public AbstractInstructionPattern<?> instructions() {
        return new AbstractInstructionPattern<>(this);
    }
}
