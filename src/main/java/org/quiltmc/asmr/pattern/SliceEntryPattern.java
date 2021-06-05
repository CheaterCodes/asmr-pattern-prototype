package org.quiltmc.asmr.pattern;

import java.util.function.Function;

public abstract class SliceEntryPattern<SELF extends SliceEntryPattern<SELF>> extends AbstractPattern<SELF> {
    protected Operation operation = Operation.NONE;

    protected SliceEntryPattern(AbstractPattern<?> parent) {
        super(parent);
    }

    private SELF operation(Operation op) {
        SELF child = this.create(this);
        child.operation = op;
        return child;
    }

    public final SELF first() {
        return operation(Operation.FIRST);
    }

    public final SELF last() {
        return operation(Operation.LAST);
    }

    public final SELF before() {
        return operation(Operation.BEFORE);
    }

    public final SELF after() {
        return operation(Operation.AFTER);
    }

    public final SlicePattern<SELF> slice(Function<SELF, AbstractPattern<?>> startProvider, Function<SELF, AbstractPattern<?>> endProvider) {
        AbstractPattern<?> startPattern = startProvider.apply(getThis());
        AbstractPattern<?> endPattern = endProvider.apply(getThis());

        if (!startPattern.isChildOf(this) || endPattern.isChildOf(this)) {
            throw new IllegalArgumentException("Provided child is not a child of this pattern");
        }

        return new SlicePattern<>(this, startPattern, endPattern, this::create);
    }

    private enum Operation {
        NONE,
        FIRST,
        LAST,
        BEFORE,
        AFTER
    }
}
