package org.quiltmc.asmr.pattern;

public class InstructionPattern<SELF extends InstructionPattern<SELF>> extends AbstractInstructionPattern<SELF> {
    protected InstructionPattern(Pattern<?> parent) {
        super(parent);
    }

    @Override
    protected SELF create(Pattern<?> parent) {
        return new InstructionPattern<SELF>(parent).getThis();
    }

    public ValuePattern<Integer> opcode() {
        return new ValuePattern<>("opcode", this);
    }

    public MethodInstructionPattern methodInstruction() {
        return new MethodInstructionPattern(this);
    }
}
