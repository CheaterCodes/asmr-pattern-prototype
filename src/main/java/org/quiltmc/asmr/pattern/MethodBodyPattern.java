package org.quiltmc.asmr.pattern;

public class MethodBodyPattern extends AbstractPattern<MethodBodyPattern> {
    protected MethodBodyPattern(AbstractPattern<?> parent) {
        super(parent);
    }

    @Override
    protected MethodBodyPattern create(AbstractPattern<?> parent) {
        return new MethodBodyPattern(parent);
    }

    public AbstractInstructionPattern<?> instructions() {
        return new AbstractInstructionPattern<>(this);
    }
}
