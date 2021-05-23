package org.quiltmc.asmr.pattern;

import org.quiltmc.asmr.tree.AbstractNode;

public class NodePattern<P, N extends AbstractNode<P, ? extends N>> extends AbstractPattern<P, N, NodePattern<P, N>> {
    public NodePattern(Class<? extends N> nodeClass) {
        super(nodeClass);
    }

    @Override
    protected NodePattern<P, N> newInstance() {
        return new NodePattern<>(nodeClass);
    }
}
