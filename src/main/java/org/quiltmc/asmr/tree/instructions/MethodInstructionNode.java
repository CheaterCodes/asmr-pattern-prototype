package org.quiltmc.asmr.tree.instructions;

import org.quiltmc.asmr.tree.AbstractNode;
import org.quiltmc.asmr.tree.AbstractValueNode;
import org.quiltmc.asmr.tree.MethodNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MethodInstructionNode extends InstructionNode {
    private final OwnerNode owner = new OwnerNode(this);
    private final NameNode name = new NameNode(this);
    private final DescriptorNode descriptor = new DescriptorNode(this);
    private final InterfaceNode itf = new InterfaceNode(this);

    private final List<AbstractNode<? extends AbstractInstructionNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            visibleAnnotations(),
            invisibleAnnotations(),
            opcode(),
            owner,
            name,
            descriptor,
            itf
    ));

    protected MethodInstructionNode(MethodNode.InstructionListNode instructionListNode) {
        super(instructionListNode);
    }

    @Override
    public List<AbstractNode<? extends AbstractInstructionNode, ?>> children() {
        return children;
    }

    public static class OwnerNode extends AbstractValueNode<MethodInstructionNode, OwnerNode, String> {
        protected OwnerNode(MethodInstructionNode methodInstructionNode) {
            super(methodInstructionNode);
        }
    }

    public static class NameNode extends AbstractValueNode<MethodInstructionNode, NameNode, String> {
        protected NameNode(MethodInstructionNode methodInstructionNode) {
            super(methodInstructionNode);
        }
    }

    public static class DescriptorNode extends AbstractValueNode<MethodInstructionNode, DescriptorNode, String> {
        protected DescriptorNode(MethodInstructionNode methodInstructionNode) {
            super(methodInstructionNode);
        }
    }

    public static class InterfaceNode extends AbstractValueNode<MethodInstructionNode, InterfaceNode, Boolean> {
        protected InterfaceNode(MethodInstructionNode methodInstructionNode) {
            super(methodInstructionNode);
        }
    }
}
