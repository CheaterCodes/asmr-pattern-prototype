package org.quiltmc.asmr.tree;

import org.quiltmc.asmr.tree.annotations.AnnotationNode;
import org.quiltmc.asmr.tree.annotations.TypeAnnotationNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FieldNode extends AbstractNode<ClassNode.FieldListNode, FieldNode> {
    private final ModifierListNode modifiers = new ModifierListNode(this);

    private final NameNode name = new NameNode(this);
    private final DescriptorNode descriptor = new DescriptorNode(this);
    private final SignatureNode signatureNode = new SignatureNode(this);
    private final ValueNode value = new ValueNode(this);

    private final VisibleAnnotationListNode visibleAnnotations = new VisibleAnnotationListNode(this);
    private final InvisibleAnnotationListNode invisibleAnnotations = new InvisibleAnnotationListNode(this);

    private final VisibleTypeAnnotationListNode visibleTypeAnnotations = new VisibleTypeAnnotationListNode(this);
    private final InvisibleTypeAnnotationListNode invisibleTypeAnnotations = new InvisibleTypeAnnotationListNode(this);

    private final List<AbstractNode<? extends FieldNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            modifiers,
            name,
            descriptor,
            signatureNode,
            value,
            visibleAnnotations,
            invisibleAnnotations,
            visibleTypeAnnotations,
            invisibleTypeAnnotations
    ));

    protected FieldNode(ClassNode.FieldListNode fieldListNode) {
        super(fieldListNode);
    }

    @Override
    public List<AbstractNode<? extends FieldNode, ?>> children() {
        return children;
    }

    public static class ModifierNode extends AbstractValueNode<ModifierListNode, ModifierNode, Integer> {
        protected ModifierNode(ModifierListNode modifierListNode) {
            super(modifierListNode);
        }
    }

    public static class ModifierListNode extends AbstractListNode<FieldNode, ModifierListNode, ModifierNode> {
        protected ModifierListNode(FieldNode fieldNode) {
            super(fieldNode);
        }

        @Override
        protected ModifierNode createEntry(Class<? extends ModifierNode> clazz) {
            return new ModifierNode(this);
        }
    }

    public static class NameNode extends AbstractValueNode<FieldNode, NameNode, String> {
        protected NameNode(FieldNode fieldNode) {
            super(fieldNode);
        }
    }

    public static class DescriptorNode extends AbstractValueNode<FieldNode, DescriptorNode, String> {
        protected DescriptorNode(FieldNode fieldNode) {
            super(fieldNode);
        }
    }

    public static class SignatureNode extends AbstractValueNode<FieldNode, SignatureNode, String> {
        protected SignatureNode(FieldNode fieldNode) {
            super(fieldNode);
        }
    }
    
    public static class ValueNode extends AbstractValueNode<FieldNode, ValueNode, Object> {
        protected ValueNode(FieldNode fieldNode) {
            super(fieldNode);
        }
    }

    public static class VisibleAnnotationNode extends AnnotationNode<VisibleAnnotationListNode, VisibleAnnotationNode> {
        protected VisibleAnnotationNode(VisibleAnnotationListNode visibleAnnotationListNode) {
            super(visibleAnnotationListNode);
        }
    }

    public static class VisibleAnnotationListNode extends AbstractListNode<FieldNode, VisibleAnnotationListNode, VisibleAnnotationNode> {
        protected VisibleAnnotationListNode(FieldNode fieldNode) {
            super(fieldNode);
        }

        @Override
        protected VisibleAnnotationNode createEntry(Class<? extends VisibleAnnotationNode> clazz) {
            return new VisibleAnnotationNode(this);
        }
    }

    public static class InvisibleAnnotationNode extends AnnotationNode<InvisibleAnnotationListNode, InvisibleAnnotationNode> {
        protected InvisibleAnnotationNode(InvisibleAnnotationListNode invisibleAnnotationListNode) {
            super(invisibleAnnotationListNode);
        }
    }

    public static class InvisibleAnnotationListNode extends AbstractListNode<FieldNode, InvisibleAnnotationListNode, InvisibleAnnotationNode> {
        protected InvisibleAnnotationListNode(FieldNode fieldNode) {
            super(fieldNode);
        }

        @Override
        protected InvisibleAnnotationNode createEntry(Class<? extends InvisibleAnnotationNode> clazz) {
            return new InvisibleAnnotationNode(this);
        }
    }

    public static class VisibleTypeAnnotationNode extends TypeAnnotationNode<VisibleTypeAnnotationListNode, VisibleTypeAnnotationNode> {
        protected VisibleTypeAnnotationNode(VisibleTypeAnnotationListNode visibleTypeAnnotationListNode) {
            super(visibleTypeAnnotationListNode);
        }
    }

    public static class VisibleTypeAnnotationListNode extends AbstractListNode<FieldNode, VisibleTypeAnnotationListNode, VisibleTypeAnnotationNode> {
        protected VisibleTypeAnnotationListNode(FieldNode fieldNode) {
            super(fieldNode);
        }

        @Override
        protected VisibleTypeAnnotationNode createEntry(Class<? extends VisibleTypeAnnotationNode> clazz) {
            return new VisibleTypeAnnotationNode(this);
        }
    }

    public static class InvisibleTypeAnnotationNode extends TypeAnnotationNode<InvisibleTypeAnnotationListNode, InvisibleTypeAnnotationNode> {
        protected InvisibleTypeAnnotationNode(InvisibleTypeAnnotationListNode invisibleTypeAnnotationListNode) {
            super(invisibleTypeAnnotationListNode);
        }
    }

    public static class InvisibleTypeAnnotationListNode extends AbstractListNode<FieldNode, InvisibleTypeAnnotationListNode, InvisibleTypeAnnotationNode> {
        protected InvisibleTypeAnnotationListNode(FieldNode fieldNode) {
            super(fieldNode);
        }

        @Override
        protected InvisibleTypeAnnotationNode createEntry(Class<? extends InvisibleTypeAnnotationNode> clazz) {
            return new InvisibleTypeAnnotationNode(this);
        }
    }
}
