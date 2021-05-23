package org.quiltmc.asmr.tree;

import org.quiltmc.asmr.tree.annotations.AnnotationNode;
import org.quiltmc.asmr.tree.annotations.TypeAnnotationNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassNode extends AbstractNode<Void, ClassNode> {
    private final VersionNode version = new VersionNode(this);
    private final ModifierListNode modifiers = new ModifierListNode(this);
    private final NameNode name = new NameNode(this);
    private final SignatureNode signature = new SignatureNode(this);
    private final SuperclassNode superclass = new SuperclassNode(this);
    private final InterfaceListNode interfaces = new InterfaceListNode(this);

    private final SourceFileNode sourceFile = new SourceFileNode(this);
    private final SourceDebugNode sourceDebug = new SourceDebugNode(this);

    private final ModuleNode module = new ModuleNode(this);

    private final OuterClassNode outerClass = new OuterClassNode(this);
    private final OuterMethodNode outerMethod = new OuterMethodNode(this);
    private final OuterMethodDescriptorNode outerMethodDescriptor = new OuterMethodDescriptorNode(this);

    private final VisibleAnnotationListNode visibleAnnotations = new VisibleAnnotationListNode(this);
    private final InvisibleAnnotationListNode invisibleAnnotations = new InvisibleAnnotationListNode(this);

    private final VisibleTypeAnnotationListNode visibleTypeAnnotations = new VisibleTypeAnnotationListNode(this);
    private final InvisibleTypeAnnotationListNode invisibleTypeAnnotations = new InvisibleTypeAnnotationListNode(this);

    private final InnerClassListNode innerClasses = new InnerClassListNode(this);

    private final NestHostClassNode nestHostClass = new NestHostClassNode(this);
    private final NestMemberListNode nestMembers = new NestMemberListNode(this);

    private final FieldListNode fields = new FieldListNode(this);
    private final MethodListNode methods = new MethodListNode(this);

    private final List<AbstractNode<? extends ClassNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            version,
            modifiers,
            name,
            signature,
            superclass,
            interfaces,
            sourceFile,
            sourceDebug,
            module,
            outerClass,
            outerMethod,
            outerMethodDescriptor,
            visibleAnnotations,
            invisibleAnnotations,
            visibleTypeAnnotations,
            invisibleTypeAnnotations,
            innerClasses,
            nestHostClass,
            nestMembers,
            fields,
            methods
    ));

    protected ClassNode() {
        super(null);
    }

    @Override
    public List<AbstractNode<? extends ClassNode, ?>> children() {
        return children;
    }

    public static class VersionNode extends AbstractValueNode<ClassNode, VersionNode, Integer> {
        protected VersionNode(ClassNode classNode) {
            super(classNode);
        }
    }

    public static class ModifierNode extends AbstractValueNode<ModifierListNode, ModifierNode, Integer> {
        protected ModifierNode(ModifierListNode modifierListNode) {
            super(modifierListNode);
        }
    }

    public static class ModifierListNode extends AbstractListNode<ClassNode, ModifierListNode, ModifierNode> {
        protected ModifierListNode(ClassNode classNode) {
            super(classNode);
        }

        @Override
        protected ModifierNode createEntry(Class<? extends ModifierNode> clazz) {
            return new ModifierNode(this);
        }
    }

    public static class NameNode extends AbstractValueNode<ClassNode, NameNode, String> {
        protected NameNode(ClassNode classNode) {
            super(classNode);
        }
    }

    public static class SignatureNode extends AbstractValueNode<ClassNode, SignatureNode, String> {
        protected SignatureNode(ClassNode classNode) {
            super(classNode);
        }
    }

    public static class SuperclassNode extends AbstractValueNode<ClassNode, SuperclassNode, String> {
        protected SuperclassNode(ClassNode classNode) {
            super(classNode);
        }
    }

    public static class InterfaceNode extends AbstractValueNode<InterfaceListNode, InterfaceNode, String> {
        protected InterfaceNode(InterfaceListNode interfaceListNode) {
            super(interfaceListNode);
        }
    }

    public static class InterfaceListNode extends AbstractListNode<ClassNode, InterfaceListNode, InterfaceNode> {
        protected InterfaceListNode(ClassNode classNode) {
            super(classNode);
        }

        @Override
        protected InterfaceNode createEntry(Class<? extends InterfaceNode> clazz) {
            return new InterfaceNode(this);
        }
    }

    public static class SourceFileNode extends AbstractValueNode<ClassNode, SourceFileNode, String> {
        protected SourceFileNode(ClassNode classNode) {
            super(classNode);
        }
    }

    public static class SourceDebugNode extends AbstractValueNode<ClassNode, SourceDebugNode, String> {
        protected SourceDebugNode(ClassNode classNode) {
            super(classNode);
        }
    }

    public static class OuterClassNode extends AbstractValueNode<ClassNode, OuterClassNode, String> {
        protected OuterClassNode(ClassNode classNode) {
            super(classNode);
        }
    }

    public static class OuterMethodNode extends AbstractValueNode<ClassNode, OuterMethodNode, String> {
        protected OuterMethodNode(ClassNode classNode) {
            super(classNode);
        }
    }

    public static class OuterMethodDescriptorNode extends AbstractValueNode<ClassNode, OuterMethodDescriptorNode, String> {
        protected OuterMethodDescriptorNode(ClassNode classNode) {
            super(classNode);
        }
    }

    public static class VisibleAnnotationNode extends AnnotationNode<VisibleAnnotationListNode, VisibleAnnotationNode> {
        protected VisibleAnnotationNode(VisibleAnnotationListNode visibleAnnotationListNode) {
            super(visibleAnnotationListNode);
        }
    }

    public static class VisibleAnnotationListNode extends AbstractListNode<ClassNode, VisibleAnnotationListNode, VisibleAnnotationNode> {
        protected VisibleAnnotationListNode(ClassNode classNode) {
            super(classNode);
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

    public static class InvisibleAnnotationListNode extends AbstractListNode<ClassNode, InvisibleAnnotationListNode, InvisibleAnnotationNode> {
        protected InvisibleAnnotationListNode(ClassNode classNode) {
            super(classNode);
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

    public static class VisibleTypeAnnotationListNode extends AbstractListNode<ClassNode, VisibleTypeAnnotationListNode, VisibleTypeAnnotationNode> {
        protected VisibleTypeAnnotationListNode(ClassNode classNode) {
            super(classNode);
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

    public static class InvisibleTypeAnnotationListNode extends AbstractListNode<ClassNode, InvisibleTypeAnnotationListNode, InvisibleTypeAnnotationNode> {
        protected InvisibleTypeAnnotationListNode(ClassNode classNode) {
            super(classNode);
        }

        @Override
        protected InvisibleTypeAnnotationNode createEntry(Class<? extends InvisibleTypeAnnotationNode> clazz) {
            return new InvisibleTypeAnnotationNode(this);
        }
    }

    public static class InnerClassListNode extends AbstractListNode<ClassNode, InnerClassListNode, InnerClassNode> {
        protected InnerClassListNode(ClassNode classNode) {
            super(classNode);
        }

        @Override
        protected InnerClassNode createEntry(Class<? extends InnerClassNode> clazz) {
            return new InnerClassNode(this);
        }
    }

    public static class NestHostClassNode extends AbstractValueNode<ClassNode, NestHostClassNode, String> {
        protected NestHostClassNode(ClassNode classNode) {
            super(classNode);
        }
    }

    public static class NestMemberNode extends AbstractValueNode<NestMemberListNode, NestMemberNode, String> {
        protected NestMemberNode(NestMemberListNode nestMemberListNode) {
            super(nestMemberListNode);
        }
    }

    public static class NestMemberListNode extends AbstractListNode<ClassNode, NestMemberListNode, NestMemberNode> {
        protected NestMemberListNode(ClassNode classNode) {
            super(classNode);
        }

        @Override
        protected NestMemberNode createEntry(Class<? extends NestMemberNode> clazz) {
            return new NestMemberNode(this);
        }
    }

    public static class FieldListNode extends AbstractListNode<ClassNode, FieldListNode, FieldNode> {
        protected FieldListNode(ClassNode classNode) {
            super(classNode);
        }

        @Override
        protected FieldNode createEntry(Class<? extends FieldNode> clazz) {
            return new FieldNode(this);
        }
    }

    public static class MethodListNode extends AbstractListNode<ClassNode, MethodListNode, MethodNode> {
        protected MethodListNode(ClassNode classNode) {
            super(classNode);
        }

        @Override
        protected MethodNode createEntry(Class<? extends MethodNode> clazz) {
            return new MethodNode(this);
        }
    }
}
