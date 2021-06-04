package org.quiltmc.asmr.pattern;

public class AbstractInstructionPattern<SELF extends AbstractInstructionPattern<SELF>> extends SliceEntryPattern<SELF> {
    protected AbstractInstructionPattern(Pattern<?> parent) {
        super(parent);
    }

    @Override
    protected SELF create(Pattern<?> parent) {
        return new AbstractInstructionPattern<SELF>(parent).getThis();
    }

    public InstructionPattern<?> insn() {
        return new InstructionPattern<>(this);
    }
}
