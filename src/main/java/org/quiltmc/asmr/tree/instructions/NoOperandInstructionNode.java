package org.quiltmc.asmr.tree.instructions;

import org.quiltmc.asmr.tree.AbstractNode;
import org.quiltmc.asmr.tree.MethodNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NoOperandInstructionNode extends AbstractInstructionNode {
    private final List<AbstractNode<? extends AbstractInstructionNode, ?>> children = Collections.unmodifiableList(Arrays.<AbstractNode<? extends AbstractInstructionNode, ?>>asList(
            opcode(),
            visibleAnnotations(),
            invisibleAnnotations()
    ));

    protected NoOperandInstructionNode(MethodNode.InstructionListNode instructionListNode) {
        super(instructionListNode);
    }

    @Override
    public List<AbstractNode<? extends AbstractInstructionNode, ?>> children() {
        return children;
    }
}
