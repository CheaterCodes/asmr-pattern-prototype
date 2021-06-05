package org.quiltmc.asmr.pattern;

public class MethodInstructionPattern extends InstructionPattern<MethodInstructionPattern> {
    static {
        register(MethodInstructionPattern.class, MethodInstructionPattern::new);
    }
    protected MethodInstructionPattern(AbstractPattern<?> parent) {
        super(parent);
    }

    @Override
    protected MethodInstructionPattern create(AbstractPattern<?> parent) {
        return new MethodInstructionPattern(parent);
    }

    public ValuePattern<String> owner() {
        return new ValuePattern<>("owner", this);
    }

    public ValuePattern<String> name() {
        return new ValuePattern<>("name", this);
    }

    public ValuePattern<String> descriptor() {
        return new ValuePattern<>("descriptor", this);
    }

    public ValuePattern<Boolean> itf() {
        return new ValuePattern<>("itf", this);
    }
}
