package org.quiltmc.asmr.pattern;

public class MethodInstructionPattern extends InstructionPattern<MethodInstructionPattern> {
    protected MethodInstructionPattern(Pattern<?> parent) {
        super(parent);
    }

    @Override
    protected MethodInstructionPattern create(Pattern<?> parent) {
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
