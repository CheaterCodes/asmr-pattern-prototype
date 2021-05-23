package org.quiltmc.asmr.tree;

import java.util.List;

public abstract class AbstractNode<PARENT, SELF extends AbstractNode<PARENT, SELF>> {
    private final PARENT parent;

    protected AbstractNode(PARENT parent) {
        this.parent = parent;
    }

    @SuppressWarnings("unchecked")
    public final SELF getThis() {
        return (SELF) this;
    }

    public final PARENT getParent() {
        return parent;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void copyFrom(SELF other) {
        for (int i = 0; i < children().size(); i++) {
            AbstractNode child = children().get(i);
            child.copyFrom(other.children().get(i));
        }
    }

    public abstract List<AbstractNode<? extends SELF, ?>> children();
}
