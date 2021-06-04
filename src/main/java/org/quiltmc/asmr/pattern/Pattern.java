package org.quiltmc.asmr.pattern;

import java.util.function.Function;

public abstract class Pattern<SELF extends Pattern<SELF>> {
    protected final Pattern<?> parent;
    protected Pattern<?> child = null;

    protected Pattern(Pattern<?> parent) {
        this.parent = parent;
    }

    @SuppressWarnings("unchecked")
    protected final SELF getThis() {
        return (SELF) this;
    }

    protected abstract SELF create(Pattern<?> parent);

    public final SELF with(Function<SELF, Pattern<?>> childProvider) {
        Pattern<?> child = childProvider.apply(getThis());
        if (!child.isChildOf(this)) {
            throw new IllegalArgumentException("Provided child is not a child of this pattern");
        }

        SELF clone = this.create(this);
        clone.child = child;
        return clone;
    }

    protected final boolean isChildOf(Pattern<?> parent) {
        return this.parent != null && (this.parent == parent || this.parent.isChildOf(parent));
    }
}
