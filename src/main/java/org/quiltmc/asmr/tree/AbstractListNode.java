package org.quiltmc.asmr.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractListNode<PARENT, SELF extends AbstractListNode<PARENT, SELF, ENTRY>, ENTRY extends AbstractNode<SELF, ENTRY>> extends AbstractNode<PARENT, SELF> {
    private final List<ENTRY> entries = new ArrayList<>();

    protected AbstractListNode(PARENT parent) {
        super(parent);
    }

    public final List<ENTRY> entries() {
        return Collections.unmodifiableList(entries);
    }

    @Override
    public List<AbstractNode<? extends SELF, ?>> children() {
        return Collections.unmodifiableList(entries);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void copyFrom(SELF other) {
        for (ENTRY entry : other.entries()) {
            ENTRY newEntry = createEntry((Class<? extends ENTRY>) entry.getClass());
            newEntry.copyFrom(entry);
            entries.add(newEntry);
        }
    }

    protected abstract ENTRY createEntry(Class<? extends ENTRY> clazz);
}
