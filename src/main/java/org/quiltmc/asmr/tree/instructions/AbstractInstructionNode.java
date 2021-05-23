package org.quiltmc.asmr.tree.instructions;

import org.quiltmc.asmr.tree.AbstractNode;
import org.quiltmc.asmr.tree.MethodNode;

public abstract class AbstractInstructionNode extends AbstractNode<MethodNode.InstructionListNode, AbstractInstructionNode> {
    protected AbstractInstructionNode(MethodNode.InstructionListNode instructionListNode) {
        super(instructionListNode);
    }

    public static AbstractInstructionNode createNew(MethodNode.InstructionListNode parent, Class<? extends AbstractInstructionNode> clazz) {
        if (clazz == LabelNode.class) {
            return new LabelNode(parent);
        }
        if (clazz == NoOperandInstructionNode.class) {
            return new NoOperandInstructionNode(parent);
        }
        throw new UnsupportedOperationException(/*TODO*/);
    }
}
