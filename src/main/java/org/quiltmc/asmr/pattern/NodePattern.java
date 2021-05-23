package org.quiltmc.asmr.pattern;

import org.quiltmc.asmr.tree.AbstractNode;

public class NodePattern<P extends AbstractNode<?, ? super P>, N extends AbstractNode<? super P, ? super N>> extends AbstractPattern<P, N, NodePattern<P, N>> {
    public NodePattern(Class<? extends N> nodeClass) {
        super(nodeClass);
    }

    @Override
    protected NodePattern<P, N> newInstance() {
        return new NodePattern<>(nodeClass);
    }
}
