package org.quiltmc.asmr.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParameterNode extends AbstractNode<MethodNode.ParameterListNode, ParameterNode> {
    private final ModifierListNode modifiers = new ModifierListNode(this);
    private final NameNode name = new NameNode(this);

    private final List<AbstractNode<? extends ParameterNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            modifiers,
            name
    ));
    
    protected ParameterNode(MethodNode.ParameterListNode parameterListNode) {
        super(parameterListNode);
    }

    @Override
    public List<AbstractNode<? extends ParameterNode, ?>> children() {
        return children;
    }

    public static class ModifierNode extends AbstractValueNode<ModifierListNode, ModifierNode, Integer> {
        protected ModifierNode(ModifierListNode modifierListNode) {
            super(modifierListNode);
        }
    }

    public static class ModifierListNode extends AbstractListNode<ParameterNode, ModifierListNode, ModifierNode> {
        protected ModifierListNode(ParameterNode parameterNode) {
            super(parameterNode);
        }

        @Override
        protected ModifierNode createEntry(Class<? extends ModifierNode> clazz) {
            return new ModifierNode(this);
        }
    }
    public static class NameNode extends AbstractValueNode<ParameterNode, NameNode, String> {
        protected NameNode(ParameterNode parameterNode) {
            super(parameterNode);
        }
    }
}
