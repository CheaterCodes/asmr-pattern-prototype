package org.quiltmc.asmr.pattern;

import org.quiltmc.asmr.tree.AbstractListNode;
import org.quiltmc.asmr.tree.AbstractNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SlicePattern<P, N extends AbstractListNode<P, ? extends N, E>, E extends AbstractNode<N, E>> extends AbstractPattern<P, N, SlicePattern<P, N, E>> {
    private List<Entry<N, E, NodePattern<N, E>>> after = Collections.emptyList();
    private List<Entry<N, E, NodePattern<N, E>>> before = Collections.emptyList();

    public SlicePattern(Class<? extends N> nodeClass) {
        super(nodeClass);
    }

    @Override
    protected SlicePattern<P, N, E> newInstance() {
        return new SlicePattern<>(nodeClass);
    }

    @Override
    protected void copyFrom(SlicePattern<P, N, E> pattern) {
        super.copyFrom(pattern);
        this.after = new ArrayList<>(pattern.after);
        this.before = new ArrayList<>(pattern.before);
    }

    /**
     * Returns a new {@link SlicePattern} that ends before the specified {@link NodePattern}.
     * Note that the order of successive calls matters, i.e. {@code .before(A).before(B)}
     * is different to {@code .before(B).before(A)}}.
     *
     * @param child The {@link NodePattern} that marks the end of the new slice
     * @param inclusive Whether the specified matched node should be part of the new slice or not
     * @return A new {@link SlicePattern} ending at the specified {@link NodePattern}
     */
    public SlicePattern<P, N, E> before(NodePattern<N, E> child, boolean inclusive) {
        SlicePattern<P, N, E> newPattern = newInstance();
        newPattern.copyFrom(getThis());
        newPattern.before.add(new Entry<>(child, inclusive));
        return newPattern;
    }

    /**
     * Returns a new {@link SlicePattern} that begins after the specified {@link NodePattern}.
     * Note that the order of successive calls matters, i.e. {@code .after(A).after(B)}
     * is different to {@code .after(B).after(A)}}.
     *
     * @param child The {@link NodePattern} that marks the start of the new slice
     * @param inclusive Whether the specified matched node should be part of the new slice or not
     * @return A new {@link SlicePattern} starting at the specified {@link NodePattern}
     */
    public SlicePattern<P, N, E> after(NodePattern<N, E> child, boolean inclusive) {
        SlicePattern<P, N, E> newPattern = newInstance();
        newPattern.copyFrom(getThis());
        newPattern.after.add(new Entry<>(child, inclusive));
        return newPattern;
    }

    private static class Entry<P, N extends AbstractNode<P, N>, T extends NodePattern<P, N>> {
        private final T pattern;
        private final boolean inclusive;

        public Entry(T pattern, boolean inclusive) {
            this.pattern = pattern;
            this.inclusive = inclusive;
        }
    }
}
