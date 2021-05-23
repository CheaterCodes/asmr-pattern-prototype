package org.quiltmc.asmr.tree.instructions;

import org.quiltmc.asmr.tree.AbstractNode;
import org.quiltmc.asmr.tree.AbstractValueNode;
import org.quiltmc.asmr.tree.LocalVariableNode;
import org.quiltmc.asmr.tree.MethodNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VariableInstructionNode extends InstructionNode {
    private final LocalIndexNode index = new LocalIndexNode(this);

    private final List<AbstractNode<? extends AbstractInstructionNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            visibleAnnotations(),
            invisibleAnnotations(),
            opcode(),
            index
    ));

    protected VariableInstructionNode(MethodNode.InstructionListNode instructionListNode) {
        super(instructionListNode);
    }

    @Override
    public List<AbstractNode<? extends AbstractInstructionNode, ?>> children() {
        return children;
    }

    public static class LocalIndexNode extends AbstractValueNode<VariableInstructionNode, LocalIndexNode, LocalVariableNode.Index> {
        protected LocalIndexNode(VariableInstructionNode variableInstructionNode) {
            super(variableInstructionNode);
        }
    }
}
