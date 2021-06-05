package org.quiltmc.asmr.pattern;

import org.quiltmc.asmr.tree.method.AsmrIndex;

public class LabelPattern extends AbstractInstructionPattern<LabelPattern> {
    static {
        register(LabelPattern.class, LabelPattern::new);
    }

    protected LabelPattern(AbstractPattern<?> parent) {
        super(parent);
    }

    @Override
    protected LabelPattern create(AbstractPattern<?> parent) {
        return new LabelPattern(parent);
    }

    public ValuePattern<AsmrIndex> label() {
        return new ValuePattern<>("label", this);
    }
}
