package org.quiltmc.asmr.pattern;

import org.quiltmc.asmr.tree.AbstractNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractPattern<P extends AbstractNode<?, ? super P>, N extends AbstractNode<? super P, ? super N>, SELF extends AbstractPattern<P, N, SELF>> {
    protected final Class<? extends N> nodeClass;

    protected AbstractPattern<?, ?, ?> parent;
    protected List<AbstractPattern<? super N, ?, ?>> children = Collections.emptyList();

    public AbstractPattern(Class<? extends N> nodeClass) {
        this.nodeClass = nodeClass;
    }

    @SuppressWarnings("unchecked")
    protected final SELF getThis() {
        return (SELF) this;
    }

    protected abstract SELF newInstance();

    protected void copyFrom(SELF pattern) {
        this.parent = pattern.parent;
        this.children = new ArrayList<>(pattern.children);
    }

    public SELF parent(AbstractPattern<?, ? super P, ?> parentPattern) {
        if (parent != null) {
            throw new IllegalStateException("Pattern already has a parent!");
        }

        SELF newPattern = newInstance();
        newPattern.copyFrom(getThis());
        newPattern.parent = parentPattern;
        return newPattern;
    }

    public SELF child(AbstractPattern<? super N, ?, ?> childPattern) {
        SELF newPattern = newInstance();
        newPattern.copyFrom(getThis());
        newPattern.children.add(childPattern);
        return newPattern;
    }
}
