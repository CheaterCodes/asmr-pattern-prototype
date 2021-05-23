package org.quiltmc.asmr.tree.instructions;

import org.quiltmc.asmr.tree.AbstractNode;
import org.quiltmc.asmr.tree.AbstractValueNode;
import org.quiltmc.asmr.tree.MethodNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LdcInstructionNode extends InstructionNode {
    private final ConstantNode constant = new ConstantNode(this);

    private final List<AbstractNode<? extends AbstractInstructionNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            visibleAnnotations(),
            invisibleAnnotations(),
            opcode(),
            constant
    ));

    protected LdcInstructionNode(MethodNode.InstructionListNode instructionListNode) {
        super(instructionListNode);
    }

    @Override
    public List<AbstractNode<? extends AbstractInstructionNode, ?>> children() {
        return children;
    }

    public static class ConstantNode extends AbstractValueNode<LdcInstructionNode, ConstantNode, Object> {
        protected ConstantNode(LdcInstructionNode ldcInstructionNode) {
            super(ldcInstructionNode);
        }
    }
}
