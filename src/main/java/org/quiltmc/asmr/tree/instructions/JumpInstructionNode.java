package org.quiltmc.asmr.tree.instructions;

import org.quiltmc.asmr.tree.AbstractNode;
import org.quiltmc.asmr.tree.AbstractValueNode;
import org.quiltmc.asmr.tree.MethodNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JumpInstructionNode extends InstructionNode {
    private final TargetNode target = new TargetNode(this);

    private final List<AbstractNode<? extends AbstractInstructionNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            visibleAnnotations(),
            invisibleAnnotations(),
            opcode(),
            target
    ));

    protected JumpInstructionNode(MethodNode.InstructionListNode instructionListNode) {
        super(instructionListNode);
    }

    @Override
    public List<AbstractNode<? extends AbstractInstructionNode, ?>> children() {
        return children;
    }

    public static class TargetNode extends AbstractValueNode<JumpInstructionNode, TargetNode, LabelNode.Index> {
        protected TargetNode(JumpInstructionNode jumpInstructionNode) {
            super(jumpInstructionNode);
        }
    }
}
