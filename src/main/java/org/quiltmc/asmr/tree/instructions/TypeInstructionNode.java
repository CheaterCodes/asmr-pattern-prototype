package org.quiltmc.asmr.tree.instructions;

import org.quiltmc.asmr.tree.AbstractNode;
import org.quiltmc.asmr.tree.AbstractValueNode;
import org.quiltmc.asmr.tree.MethodNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TypeInstructionNode extends InstructionNode {
    private final DescriptorNode descriptor = new DescriptorNode(this);

    private final List<AbstractNode<? extends AbstractInstructionNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            visibleAnnotations(),
            invisibleAnnotations(),
            opcode(),
            descriptor
    ));

    protected TypeInstructionNode(MethodNode.InstructionListNode instructionListNode) {
        super(instructionListNode);
    }

    @Override
    public List<AbstractNode<? extends AbstractInstructionNode, ?>> children() {
        return children;
    }

    public static class DescriptorNode extends AbstractValueNode<TypeInstructionNode, DescriptorNode, String> {
        protected DescriptorNode(TypeInstructionNode typeInstructionNode) {
            super(typeInstructionNode);
        }
    }
}
