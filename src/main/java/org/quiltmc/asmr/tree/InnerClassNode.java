package org.quiltmc.asmr.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InnerClassNode extends AbstractNode<ClassNode.InnerClassListNode, InnerClassNode> {
    private final ModifierListNode modifiers = new ModifierListNode(this);
    private final InnerNameNode innerName = new InnerNameNode(this);
    private final NameNode name = new NameNode(this);
    private final OuterNameNode outerName = new OuterNameNode(this);

    private final List<AbstractNode<? extends InnerClassNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            modifiers,
            innerName,
            name,
            outerName
    ));

    protected InnerClassNode(ClassNode.InnerClassListNode innerClassListNode) {
        super(innerClassListNode);
    }

    @Override
    public List<AbstractNode<? extends InnerClassNode, ?>> children() {
        return children;
    }

    public static class ModifierNode extends AbstractValueNode<ModifierListNode, ModifierNode, Integer> {
        protected ModifierNode(ModifierListNode modifierListNode) {
            super(modifierListNode);
        }
    }

    public static class ModifierListNode extends AbstractListNode<InnerClassNode, ModifierListNode, ModifierNode> {
        protected ModifierListNode(InnerClassNode innerClassNode) {
            super(innerClassNode);
        }

        @Override
        protected ModifierNode createEntry(Class<? extends ModifierNode> clazz) {
            return new ModifierNode(this);
        }
    }

    private static class InnerNameNode extends AbstractValueNode<InnerClassNode, InnerNameNode, String> {
        protected InnerNameNode(InnerClassNode innerClassNode) {
            super(innerClassNode);
        }
    }

    private static class NameNode extends AbstractValueNode<InnerClassNode, NameNode, String> {
        protected NameNode(InnerClassNode innerClassNode) {
            super(innerClassNode);
        }
    }

    private static class OuterNameNode extends AbstractValueNode<InnerClassNode, OuterNameNode, String> {
        protected OuterNameNode(InnerClassNode innerClassNode) {
            super(innerClassNode);
        }
    }
}
