package org.quiltmc.asmr.pattern;

import org.quiltmc.asmr.tree.AbstractListNode;
import org.quiltmc.asmr.tree.AbstractNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SlicePattern<P extends AbstractNode<?, ? super P>, N extends AbstractListNode<? super P, ? super N, ? super E>, E extends AbstractNode<? super N, ? super E>> extends AbstractPattern<P, N, SlicePattern<P, N, E>> {
    private List<Entry<NodePattern<? super N, ? extends E>>> after = Collections.emptyList();
    private List<Entry<NodePattern<? super N, ? extends E>>> before = Collections.emptyList();

    private State state = State.Full;
    private enum State {
        ZeroStart,
        ZeroEnd,
        Full
    }

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
        this.state = pattern.state;
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
    public SlicePattern<P, N, E> before(NodePattern<? super N, ? extends E> child, boolean inclusive) {
        if (state != State.Full) {
            throw new IllegalStateException("Can't add further constraints to zero-length slice");
        }
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
    public SlicePattern<P, N, E> after(NodePattern<? super N, ? extends E> child, boolean inclusive) {
        if (state != State.Full) {
            throw new IllegalStateException("Can't add further constraints to zero-length slice");
        }
        SlicePattern<P, N, E> newPattern = newInstance();
        newPattern.copyFrom(getThis());
        newPattern.after.add(new Entry<>(child, inclusive));
        return newPattern;
    }

    /**
     * Creates a zero-length slice at the start of this slice.
     * @return A zero-length slice
     */
    public SlicePattern<P, N, E> start() {
        if (state != State.Full) {
            throw new IllegalStateException("Can't add further constraints to zero-length slice");
        }
        SlicePattern<P, N, E> newPattern = newInstance();
        newPattern.copyFrom(getThis());
        newPattern.state = State.ZeroStart;
        return newPattern;
    }

    /**
     * Creates a zero-length slice at the end of this slice.
     * @return A zero-length slice
     */
    public SlicePattern<P, N, E> end() {
        if (state != State.Full) {
            throw new IllegalStateException("Can't add further constraints to zero-length slice");
        }
        SlicePattern<P, N, E> newPattern = newInstance();
        newPattern.copyFrom(getThis());
        newPattern.state = State.ZeroEnd;
        return newPattern;
    }

    private static class Entry<T extends NodePattern<?, ?>> {
        private final T pattern;
        private final boolean inclusive;

        public Entry(T pattern, boolean inclusive) {
            this.pattern = pattern;
            this.inclusive = inclusive;
        }
    }
}
