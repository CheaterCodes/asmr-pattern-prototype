package org.quiltmc.asmr.pattern;

import java.util.function.Supplier;

public class SlicePattern<T extends Pattern<?>> {
    private final T first;
    private final T last;
    private final T all;

    protected SlicePattern(Supplier<T> anySupplier) {
        first = anySupplier.get();
        last = anySupplier.get();
        all = anySupplier.get();
    }

    /**
     * Returns the pattern that restricts this slice's first element.
     * This pattern can also be used to match the first element of this slice.
     * @return The pattern representing the first element of this slice
     */
    public T first() {
        return first;
    }

    /**
     * Returns the pattern that restricts this slice's last element.
     * This pattern can also be used to match the last element of this slice.
     * @return The pattern representing the last element of this slice
     */
    public T last() {
        return last;
    }

    /**
     * Returns the pattern that restricts all elements of this slice.
     * This pattern can also be used to match all elements of this slice.
     * @return The pattern representing all elements of this slice
     */
    public T all() {
        return all;
    }

    /**
     * Returns a new slice pattern that must be contained in this slice.
     * This pattern can also be used to match all slice patterns of this slice.
     * @return The slice pattern that must be contained in this slice
     */
    public SlicePattern<T> slice() {

    }
}
