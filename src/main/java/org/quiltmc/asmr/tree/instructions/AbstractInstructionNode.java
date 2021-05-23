package org.quiltmc.asmr.tree.instructions;

import org.quiltmc.asmr.tree.*;
import org.quiltmc.asmr.tree.annotations.AnnotationNode;

public abstract class AbstractInstructionNode extends AbstractNode<MethodNode.InstructionListNode, AbstractInstructionNode> {
    private final OpcodeNode opcode = new OpcodeNode(getThis());

    private final VisibleAnnotationListNode visibleAnnotations = new VisibleAnnotationListNode(getThis());
    private final InvisibleAnnotationListNode invisibleAnnotations = new InvisibleAnnotationListNode(getThis());

    protected AbstractInstructionNode(MethodNode.InstructionListNode instructionListNode) {
        super(instructionListNode);
    }

    public OpcodeNode opcode() {
        return opcode;
    }

    public VisibleAnnotationListNode visibleAnnotations() {
        return visibleAnnotations;
    }

    public InvisibleAnnotationListNode invisibleAnnotations() {
        return invisibleAnnotations;
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

    public static class OpcodeNode extends AbstractValueNode<AbstractInstructionNode, OpcodeNode, Integer> {
        protected OpcodeNode(AbstractInstructionNode abstractInstructionNode) {
            super(abstractInstructionNode);
        }
    }

    public static class VisibleAnnotationNode extends AnnotationNode<VisibleAnnotationListNode, VisibleAnnotationNode> {
        protected VisibleAnnotationNode(VisibleAnnotationListNode parentVisibleAnnotationListNode) {
            super(parentVisibleAnnotationListNode);
        }
    }

    public static class VisibleAnnotationListNode extends AbstractListNode<AbstractInstructionNode, VisibleAnnotationListNode, VisibleAnnotationNode> {
        protected VisibleAnnotationListNode(AbstractInstructionNode parent) {
            super(parent);
        }

        @Override
        protected VisibleAnnotationNode createEntry(Class<? extends VisibleAnnotationNode> clazz) {
            return new VisibleAnnotationNode(this);
        }
    }

    public static class InvisibleAnnotationNode extends AnnotationNode<InvisibleAnnotationListNode, InvisibleAnnotationNode> {
        protected InvisibleAnnotationNode(InvisibleAnnotationListNode parentInvisibleAnnotationListNode) {
            super(parentInvisibleAnnotationListNode);
        }
    }

    public static class InvisibleAnnotationListNode extends AbstractListNode<AbstractInstructionNode, InvisibleAnnotationListNode, InvisibleAnnotationNode> {
        protected InvisibleAnnotationListNode(AbstractInstructionNode parent) {
            super(parent);
        }

        @Override
        protected InvisibleAnnotationNode createEntry(Class<? extends InvisibleAnnotationNode> clazz) {
            return new InvisibleAnnotationNode(this);
        }
    }
}
