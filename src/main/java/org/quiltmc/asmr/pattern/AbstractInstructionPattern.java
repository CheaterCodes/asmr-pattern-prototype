package org.quiltmc.asmr.pattern;

public class AbstractInstructionPattern<SELF extends AbstractInstructionPattern<SELF>> extends SliceEntryPattern<SELF> {
    protected AbstractInstructionPattern(AbstractPattern<?> parent) {
        super(parent);
    }

    @Override
    protected SELF create(AbstractPattern<?> parent) {
        return new AbstractInstructionPattern<SELF>(parent).getThis();
    }

    public InstructionPattern<?> filterInstruction() {
        return new InstructionPattern<>(this);
    }

    public LabelPattern filterLabel() {
        return new LabelPattern(this);
    }

    public ValuePattern<Integer> opcode() {
        return this.filterInstruction().opcode();
    }

    public MethodInstructionPattern methodInstruction() {
        return this.filterInstruction().methodInstruction();
    }

}
