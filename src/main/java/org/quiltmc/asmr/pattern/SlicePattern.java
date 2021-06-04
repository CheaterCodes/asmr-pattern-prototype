package org.quiltmc.asmr.pattern;

import java.util.function.Function;

public class SlicePattern<T extends SliceEntryPattern<T>> extends Pattern<SlicePattern<T>> {
    private final Function<SlicePattern<T>, T> childFactory;
    private final Pattern<?> startPattern;
    private final Pattern<?> endPattern;

    protected SlicePattern(Pattern<?> parent, Pattern<?> startPattern, Pattern<?> endPattern, Function<SlicePattern<T>, T> childFactory) {
        super(parent);
        this.startPattern = startPattern;
        this.endPattern = endPattern;
        this.childFactory = childFactory;
    }

    public final T entries() {
        return childFactory.apply(this);
    }

    @Override
    protected SlicePattern<T> create(Pattern<?> parent) {
        throw new UnsupportedOperationException("Can't create SlicePattern as child");
    }
}
