package org.quiltmc.asmr.tree.instructions;

import org.quiltmc.asmr.tree.AbstractNode;
import org.quiltmc.asmr.tree.AbstractValueNode;
import org.quiltmc.asmr.tree.LocalVariableNode;
import org.quiltmc.asmr.tree.MethodNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IIncInstructionNode extends InstructionNode {
    private final LocalIndexNode localIndex = new LocalIndexNode(this);
    private final IncrementNode increment = new IncrementNode(this);

    private final List<AbstractNode<? extends AbstractInstructionNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            visibleAnnotations(),
            invisibleAnnotations(),
            opcode(),
            localIndex,
            increment
    ));

    protected IIncInstructionNode(MethodNode.InstructionListNode instructionListNode) {
        super(instructionListNode);
    }

    @Override
    public List<AbstractNode<? extends AbstractInstructionNode, ?>> children() {
        return children;
    }

    public static class LocalIndexNode extends AbstractValueNode<IIncInstructionNode, LocalIndexNode, LocalVariableNode.Index> {
        protected LocalIndexNode(IIncInstructionNode iIncInstructionNode) {
            super(iIncInstructionNode);
        }
    }

    public static class IncrementNode extends AbstractValueNode<IIncInstructionNode, IncrementNode, Integer> {
        protected IncrementNode(IIncInstructionNode iIncInstructionNode) {
            super(iIncInstructionNode);
        }
    }
}
