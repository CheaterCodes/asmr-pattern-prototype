package org.quiltmc.asmr.tree.instructions;

import org.quiltmc.asmr.tree.AbstractNode;
import org.quiltmc.asmr.tree.AbstractValueNode;
import org.quiltmc.asmr.tree.MethodNode;

import java.util.Collections;
import java.util.List;

public class LabelNode extends AbstractInstructionNode {
    private final IndexNode index = new IndexNode(this);

    private final List<AbstractNode<? extends AbstractInstructionNode, ?>> children = Collections.singletonList(
            index
    );

    protected LabelNode(MethodNode.InstructionListNode instructionListNode) {
        super(instructionListNode);
    }

    @Override
    public List<AbstractNode<? extends AbstractInstructionNode, ?>> children() {
        return children;
    }

    public static class Index {}

    public static class IndexNode extends AbstractValueNode<LabelNode, IndexNode, Index> {
        protected IndexNode(LabelNode labelNode) {
            super(labelNode);
        }
    }
}
