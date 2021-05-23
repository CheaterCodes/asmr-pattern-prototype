package org.quiltmc.asmr.tree;

import java.util.Collections;
import java.util.List;

public abstract class AbstractValueNode<PARENT, SELF extends AbstractValueNode<PARENT, SELF, VALUE>, VALUE> extends AbstractNode<PARENT, SELF> {
    private VALUE value = null;

    protected AbstractValueNode(PARENT parent) {
        super(parent);
    }

    public final void init(VALUE value) {
        if (this.value != null) {
            throw new IllegalStateException("Already initialized!");
        }
        this.value = value;
    }

    public final VALUE value() {
        if (this.value == null) {
            throw new IllegalStateException("Not yet initialized!");
        }
        return value;
    }

    @Override
    public List<AbstractNode<? extends SELF, ?>> children() {
        return Collections.emptyList();
    }

    @Override
    public void copyFrom(SELF other) {
        init(other.value());
    }
}
