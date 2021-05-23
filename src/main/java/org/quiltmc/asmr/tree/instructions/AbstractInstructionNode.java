package org.quiltmc.asmr.tree.instructions;

import org.quiltmc.asmr.tree.AbstractNode;
import org.quiltmc.asmr.tree.MethodNode;

public abstract class AbstractInstructionNode extends AbstractNode<MethodNode.InstructionListNode, AbstractInstructionNode> {
    protected AbstractInstructionNode(MethodNode.InstructionListNode instructionListNode) {
        super(instructionListNode);
    }

    public static AbstractInstructionNode createNew(MethodNode.InstructionListNode parent, Class<? extends AbstractInstructionNode> clazz) {
        if (clazz == FieldInstructionNode.class) {
            return new FieldInstructionNode(parent);
        }
        if (clazz == IIncInstructionNode.class) {
            return new IIncInstructionNode(parent);
        }
        if (clazz == IntegerInstructionNode.class) {
            return new IntegerInstructionNode(parent);
        }
        if (clazz == JumpInstructionNode.class) {
            return new JumpInstructionNode(parent);
        }
        if (clazz == LabelNode.class) {
            return new LabelNode(parent);
        }
        if (clazz == LdcInstructionNode.class) {
            return new LdcInstructionNode(parent);
        }
        if (clazz == LineNumberNode.class) {
            return new LineNumberNode(parent);
        }
        if (clazz == MethodInstructionNode.class) {
            return new MethodInstructionNode(parent);
        }
        if (clazz == MultiANewArrayInstructionNode.class) {
            return new MultiANewArrayInstructionNode(parent);
        }
        if (clazz == NoOperandInstructionNode.class) {
            return new NoOperandInstructionNode(parent);
        }
        if (clazz == SwitchInstructionNode.class) {
            return new SwitchInstructionNode(parent);
        }
        if (clazz == TypeInstructionNode.class) {
            return new TypeInstructionNode(parent);
        }
        if (clazz == VariableInstructionNode.class) {
            return new VariableInstructionNode(parent);
        }
        throw new IllegalArgumentException("Unknown class");
    }
}
