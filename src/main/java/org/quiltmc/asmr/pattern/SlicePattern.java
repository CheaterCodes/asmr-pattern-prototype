package org.quiltmc.asmr.pattern;

import java.util.function.Function;

public class SlicePattern<T extends SliceEntryPattern<T>> extends AbstractPattern<SlicePattern<T>> {
    private final Function<SlicePattern<T>, T> childFactory;
    private final AbstractPattern<?> startPattern;
    private final AbstractPattern<?> endPattern;

    protected SlicePattern(AbstractPattern<?> parent, AbstractPattern<?> startPattern, AbstractPattern<?> endPattern, Function<SlicePattern<T>, T> childFactory) {
        super(parent);
        this.startPattern = startPattern;
        this.endPattern = endPattern;
        this.childFactory = childFactory;
    }

    public final T entries() {
        return childFactory.apply(this);
    }

    @Override
    protected SlicePattern<T> create(AbstractPattern<?> parent) {
        throw new UnsupportedOperationException("Can't create SlicePattern as child");
    }
}
