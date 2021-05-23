package org.quiltmc.asmr.tree.instructions;

import org.quiltmc.asmr.tree.AbstractNode;
import org.quiltmc.asmr.tree.AbstractValueNode;
import org.quiltmc.asmr.tree.MethodNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FieldInstructionNode extends InstructionNode {
    private final OwnerNode owner = new OwnerNode(this);
    private final NameNode name = new NameNode(this);
    private final DescriptorNode descriptor = new DescriptorNode(this);

    private final List<AbstractNode<? extends AbstractInstructionNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            visibleAnnotations(),
            invisibleAnnotations(),
            opcode(),
            owner,
            name,
            descriptor
    ));

    protected FieldInstructionNode(MethodNode.InstructionListNode instructionListNode) {
        super(instructionListNode);
    }

    @Override
    public List<AbstractNode<? extends AbstractInstructionNode, ?>> children() {
        return children;
    }

    public static class OwnerNode extends AbstractValueNode<FieldInstructionNode, OwnerNode, String> {
        protected OwnerNode(FieldInstructionNode fieldInstructionNode) {
            super(fieldInstructionNode);
        }
    }

    public static class NameNode extends AbstractValueNode<FieldInstructionNode, NameNode, String> {
        protected NameNode(FieldInstructionNode fieldInstructionNode) {
            super(fieldInstructionNode);
        }
    }

    public static class DescriptorNode extends AbstractValueNode<FieldInstructionNode, DescriptorNode, String> {
        protected DescriptorNode(FieldInstructionNode fieldInstructionNode) {
            super(fieldInstructionNode);
        }
    }
}
