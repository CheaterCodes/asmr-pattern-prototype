package org.quiltmc.asmr.tree.instructions;

import org.quiltmc.asmr.tree.*;
import org.quiltmc.asmr.tree.annotations.AnnotationNode;

public abstract class InstructionNode extends AbstractInstructionNode {
    private final OpcodeNode opcode = new OpcodeNode(this);

    private final VisibleAnnotationListNode visibleAnnotations = new VisibleAnnotationListNode(this);
    private final InvisibleAnnotationListNode invisibleAnnotations = new InvisibleAnnotationListNode(this);

    protected InstructionNode(MethodNode.InstructionListNode instructionListNode) {
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

    public static class OpcodeNode extends AbstractValueNode<InstructionNode, OpcodeNode, Integer> {
        protected OpcodeNode(InstructionNode abstractInstructionNode) {
            super(abstractInstructionNode);
        }
    }

    public static class VisibleAnnotationNode extends AnnotationNode<VisibleAnnotationListNode, VisibleAnnotationNode> {
        protected VisibleAnnotationNode(VisibleAnnotationListNode parentVisibleAnnotationListNode) {
            super(parentVisibleAnnotationListNode);
        }
    }

    public static class VisibleAnnotationListNode extends AbstractListNode<InstructionNode, VisibleAnnotationListNode, VisibleAnnotationNode> {
        protected VisibleAnnotationListNode(InstructionNode parent) {
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

    public static class InvisibleAnnotationListNode extends AbstractListNode<InstructionNode, InvisibleAnnotationListNode, InvisibleAnnotationNode> {
        protected InvisibleAnnotationListNode(InstructionNode parent) {
            super(parent);
        }

        @Override
        protected InvisibleAnnotationNode createEntry(Class<? extends InvisibleAnnotationNode> clazz) {
            return new InvisibleAnnotationNode(this);
        }
    }
}
