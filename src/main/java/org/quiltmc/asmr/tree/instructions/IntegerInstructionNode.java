package org.quiltmc.asmr.tree.instructions;

import org.quiltmc.asmr.tree.AbstractNode;
import org.quiltmc.asmr.tree.AbstractValueNode;
import org.quiltmc.asmr.tree.MethodNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntegerInstructionNode extends InstructionNode {
    private final OperandNode operand = new OperandNode(this);

    private final List<AbstractNode<? extends AbstractInstructionNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            visibleAnnotations(),
            invisibleAnnotations(),
            opcode(),
            operand
    ));

    protected IntegerInstructionNode(MethodNode.InstructionListNode instructionListNode) {
        super(instructionListNode);
    }

    @Override
    public List<AbstractNode<? extends AbstractInstructionNode, ?>> children() {
        return children;
    }

    public static class OperandNode extends AbstractValueNode<IntegerInstructionNode, OperandNode, Integer> {
        protected OperandNode(IntegerInstructionNode integerInstructionNode) {
            super(integerInstructionNode);
        }
    }
}
