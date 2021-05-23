package org.quiltmc.asmr.tree;

import org.quiltmc.asmr.tree.annotations.AnnotationNode;
import org.quiltmc.asmr.tree.annotations.TypeAnnotationNode;
import org.quiltmc.asmr.tree.instructions.AbstractInstructionNode;
import org.quiltmc.asmr.tree.instructions.InstructionNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MethodNode extends AbstractNode<ClassNode.MethodListNode, MethodNode> {
    private final ModifierListNode modifiers = new ModifierListNode(this);
    private final NameNode name = new NameNode(this);
    private final DescriptorNode descriptor = new DescriptorNode(this);
    private final SignatureNode signature = new SignatureNode(this);
    private final ExceptionListNode exceptions = new ExceptionListNode(this);

    private final ParameterListNode parameters = new ParameterListNode(this);
    private final LocalVariableListNode locals = new LocalVariableListNode(this);
    private final TryCatchBlockListNode tryCatchBlocks = new TryCatchBlockListNode(this);

    private final InstructionListNode instructions = new InstructionListNode(this);
    
    private final VisibleAnnotationListNode visibleAnnotations = new VisibleAnnotationListNode(this);
    private final InvisibleAnnotationListNode invisibleAnnotations = new InvisibleAnnotationListNode(this);

    private final VisibleTypeAnnotationListNode visibleTypeAnnotations = new VisibleTypeAnnotationListNode(this);
    private final InvisibleTypeAnnotationListNode invisibleTypeAnnotations = new InvisibleTypeAnnotationListNode(this);

    private final VisibleAnnotableParameterCountNode visibleAnnotableParameterCount = new VisibleAnnotableParameterCountNode(this);
    private final VisibleParameterAnnotationListListNode visibleParameterAnnotations = new VisibleParameterAnnotationListListNode(this);
    private final InvisibleAnnotableParameterCountNode invisibleAnnotableParameterCount = new InvisibleAnnotableParameterCountNode(this);
    private final InvisibleParameterAnnotationListListNode invisibleParameterAnnotations = new InvisibleParameterAnnotationListListNode(this);

    private final VisibleLocalVariableAnnotationListNode visibleLocalVariableAnnotations = new VisibleLocalVariableAnnotationListNode(this);
    private final InvisibleLocalVariableAnnotationListNode invisibleLocalVariableAnnotations = new InvisibleLocalVariableAnnotationListNode(this);

    private final AnnotationDefaultNode annotationDefault = new AnnotationDefaultNode(this);

    private final List<AbstractNode<? extends MethodNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            modifiers,
            name,
            descriptor,
            signature,
            exceptions,
            parameters,
            locals,
            tryCatchBlocks,
            instructions,
            visibleAnnotations,
            invisibleAnnotations,
            visibleTypeAnnotations,
            invisibleTypeAnnotations,
            visibleAnnotableParameterCount,
            visibleParameterAnnotations,
            invisibleAnnotableParameterCount,
            invisibleParameterAnnotations,
            visibleLocalVariableAnnotations,
            invisibleLocalVariableAnnotations,
            annotationDefault
    ));

    protected MethodNode(ClassNode.MethodListNode methodListNode) {
        super(methodListNode);
    }

    @Override
    public List<AbstractNode<? extends MethodNode, ?>> children() {
        return children;
    }

    public static class ModifierNode extends AbstractValueNode<ModifierListNode, ModifierNode, Integer> {
        protected ModifierNode(ModifierListNode modifierListNode) {
            super(modifierListNode);
        }
    }

    public static class ModifierListNode extends AbstractListNode<MethodNode, ModifierListNode, ModifierNode> {
        protected ModifierListNode(MethodNode methodNode) {
            super(methodNode);
        }

        @Override
        protected ModifierNode createEntry(Class<? extends ModifierNode> clazz) {
            return new ModifierNode(this);
        }
    }

    public static class NameNode extends AbstractValueNode<MethodNode, NameNode, String> {
        protected NameNode(MethodNode methodNode) {
            super(methodNode);
        }
    }

    public static class DescriptorNode extends AbstractValueNode<MethodNode, DescriptorNode, String> {
        protected DescriptorNode(MethodNode methodNode) {
            super(methodNode);
        }
    }

    public static class SignatureNode extends AbstractValueNode<MethodNode, SignatureNode, String> {
        protected SignatureNode(MethodNode methodNode) {
            super(methodNode);
        }
    }

    public static class ExceptionNode extends AbstractValueNode<ExceptionListNode, ExceptionNode, String> {
        protected ExceptionNode(ExceptionListNode exceptionListNode) {
            super(exceptionListNode);
        }
    }

    public static class ExceptionListNode extends AbstractListNode<MethodNode, ExceptionListNode, ExceptionNode> {
        protected ExceptionListNode(MethodNode methodNode) {
            super(methodNode);
        }

        @Override
        protected ExceptionNode createEntry(Class<? extends ExceptionNode> clazz) {
            return new ExceptionNode(this);
        }
    }

    public static class ParameterListNode extends AbstractListNode<MethodNode, ParameterListNode, ParameterNode> {
        protected ParameterListNode(MethodNode methodNode) {
            super(methodNode);
        }

        @Override
        protected ParameterNode createEntry(Class<? extends ParameterNode> clazz) {
            return new ParameterNode(this);
        }
    }

    public static class LocalVariableListNode extends AbstractListNode<MethodNode, LocalVariableListNode, LocalVariableNode> {
        protected LocalVariableListNode(MethodNode methodNode) {
            super(methodNode);
        }

        @Override
        protected LocalVariableNode createEntry(Class<? extends LocalVariableNode> clazz) {
            return new LocalVariableNode(this);
        }
    }

    public static class TryCatchBlockListNode extends AbstractListNode<MethodNode, TryCatchBlockListNode, TryCatchBlockNode> {
        protected TryCatchBlockListNode(MethodNode methodNode) {
            super(methodNode);
        }

        @Override
        protected TryCatchBlockNode createEntry(Class<? extends TryCatchBlockNode> clazz) {
            return new TryCatchBlockNode(this);
        }
    }

    public static class InstructionListNode extends AbstractListNode<MethodNode, InstructionListNode, AbstractInstructionNode> {
        protected InstructionListNode(MethodNode methodNode) {
            super(methodNode);
        }

        @Override
        protected AbstractInstructionNode createEntry(Class<? extends AbstractInstructionNode> clazz) {
            return AbstractInstructionNode.createNew(this, clazz);
        }
    }

    public static class VisibleAnnotationNode extends AnnotationNode<VisibleAnnotationListNode, VisibleAnnotationNode> {
        protected VisibleAnnotationNode(VisibleAnnotationListNode visibleAnnotationListNode) {
            super(visibleAnnotationListNode);
        }
    }

    public static class VisibleAnnotationListNode extends AbstractListNode<MethodNode, VisibleAnnotationListNode, VisibleAnnotationNode> {
        protected VisibleAnnotationListNode(MethodNode methodNode) {
            super(methodNode);
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

    public static class InvisibleAnnotationListNode extends AbstractListNode<MethodNode, InvisibleAnnotationListNode, InvisibleAnnotationNode> {
        protected InvisibleAnnotationListNode(MethodNode methodNode) {
            super(methodNode);
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

    public static class VisibleTypeAnnotationListNode extends AbstractListNode<MethodNode, VisibleTypeAnnotationListNode, VisibleTypeAnnotationNode> {
        protected VisibleTypeAnnotationListNode(MethodNode methodNode) {
            super(methodNode);
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

    public static class InvisibleTypeAnnotationListNode extends AbstractListNode<MethodNode, InvisibleTypeAnnotationListNode, InvisibleTypeAnnotationNode> {
        protected InvisibleTypeAnnotationListNode(MethodNode methodNode) {
            super(methodNode);
        }

        @Override
        protected InvisibleTypeAnnotationNode createEntry(Class<? extends InvisibleTypeAnnotationNode> clazz) {
            return new InvisibleTypeAnnotationNode(this);
        }
    }

    public static class VisibleAnnotableParameterCountNode extends AbstractValueNode<MethodNode, VisibleAnnotableParameterCountNode, Integer> {
        protected VisibleAnnotableParameterCountNode(MethodNode methodNode) {
            super(methodNode);
        }
    }

    public static class VisibleParameterAnnotationNode extends AnnotationNode<VisibleParameterAnnotationListNode, VisibleParameterAnnotationNode> {
        protected VisibleParameterAnnotationNode(VisibleParameterAnnotationListNode visibleParameterAnnotationListNode) {
            super(visibleParameterAnnotationListNode);
        }
    }

    public static class VisibleParameterAnnotationListNode extends AbstractListNode<VisibleParameterAnnotationListListNode, VisibleParameterAnnotationListNode, VisibleParameterAnnotationNode> {
        protected VisibleParameterAnnotationListNode(VisibleParameterAnnotationListListNode visibleParameterAnnotationListListNode) {
            super(visibleParameterAnnotationListListNode);
        }

        @Override
        protected VisibleParameterAnnotationNode createEntry(Class<? extends VisibleParameterAnnotationNode> clazz) {
            return new VisibleParameterAnnotationNode(this);
        }
    }

    public static class VisibleParameterAnnotationListListNode extends AbstractListNode<MethodNode, VisibleParameterAnnotationListListNode, VisibleParameterAnnotationListNode> {
        protected VisibleParameterAnnotationListListNode(MethodNode methodNode) {
            super(methodNode);
        }

        @Override
        protected VisibleParameterAnnotationListNode createEntry(Class<? extends VisibleParameterAnnotationListNode> clazz) {
            return new VisibleParameterAnnotationListNode(this);
        }
    }

    public static class InvisibleAnnotableParameterCountNode extends AbstractValueNode<MethodNode, InvisibleAnnotableParameterCountNode, Integer> {
        protected InvisibleAnnotableParameterCountNode(MethodNode methodNode) {
            super(methodNode);
        }
    }

    public static class InvisibleParameterAnnotationNode extends AnnotationNode<InvisibleParameterAnnotationListNode, InvisibleParameterAnnotationNode> {
        protected InvisibleParameterAnnotationNode(InvisibleParameterAnnotationListNode invisibleParameterAnnotationListNode) {
            super(invisibleParameterAnnotationListNode);
        }
    }

    public static class InvisibleParameterAnnotationListNode extends AbstractListNode<InvisibleParameterAnnotationListListNode, InvisibleParameterAnnotationListNode, InvisibleParameterAnnotationNode> {
        protected InvisibleParameterAnnotationListNode(InvisibleParameterAnnotationListListNode invisibleParameterAnnotationListListNode) {
            super(invisibleParameterAnnotationListListNode);
        }

        @Override
        protected InvisibleParameterAnnotationNode createEntry(Class<? extends InvisibleParameterAnnotationNode> clazz) {
            return new InvisibleParameterAnnotationNode(this);
        }
    }

    public static class InvisibleParameterAnnotationListListNode extends AbstractListNode<MethodNode, InvisibleParameterAnnotationListListNode, InvisibleParameterAnnotationListNode> {
        protected InvisibleParameterAnnotationListListNode(MethodNode methodNode) {
            super(methodNode);
        }

        @Override
        protected InvisibleParameterAnnotationListNode createEntry(Class<? extends InvisibleParameterAnnotationListNode> clazz) {
            return new InvisibleParameterAnnotationListNode(this);
        }
    }

    public static class VisibleLocalVariableAnnotationNode extends AnnotationNode<VisibleLocalVariableAnnotationListNode, VisibleLocalVariableAnnotationNode> {
        protected VisibleLocalVariableAnnotationNode(VisibleLocalVariableAnnotationListNode visibleLocalVariableAnnotationListNode) {
            super(visibleLocalVariableAnnotationListNode);
        }
    }

    public static class VisibleLocalVariableAnnotationListNode extends AbstractListNode<MethodNode, VisibleLocalVariableAnnotationListNode, VisibleLocalVariableAnnotationNode> {
        protected VisibleLocalVariableAnnotationListNode(MethodNode methodNode) {
            super(methodNode);
        }

        @Override
        protected VisibleLocalVariableAnnotationNode createEntry(Class<? extends VisibleLocalVariableAnnotationNode> clazz) {
            return new VisibleLocalVariableAnnotationNode(this);
        }
    }

    public static class InvisibleLocalVariableAnnotationNode extends AnnotationNode<InvisibleLocalVariableAnnotationListNode, InvisibleLocalVariableAnnotationNode> {
        protected InvisibleLocalVariableAnnotationNode(InvisibleLocalVariableAnnotationListNode invisibleLocalVariableAnnotationListNode) {
            super(invisibleLocalVariableAnnotationListNode);
        }
    }

    public static class InvisibleLocalVariableAnnotationListNode extends AbstractListNode<MethodNode, InvisibleLocalVariableAnnotationListNode, InvisibleLocalVariableAnnotationNode> {
        protected InvisibleLocalVariableAnnotationListNode(MethodNode methodNode) {
            super(methodNode);
        }

        @Override
        protected InvisibleLocalVariableAnnotationNode createEntry(Class<? extends InvisibleLocalVariableAnnotationNode> clazz) {
            return new InvisibleLocalVariableAnnotationNode(this);
        }
    }

    // TODO: For now simply an Object
    public static class AnnotationDefaultNode extends AbstractValueNode<MethodNode, AnnotationDefaultNode, Object> {
        protected AnnotationDefaultNode(MethodNode methodNode) {
            super(methodNode);
        }
    }
}
