package org.quiltmc.asmr.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ModuleNode extends AbstractNode<ClassNode, ModuleNode> {
    private final VersionNode version = new VersionNode(this);
    private final ModifierListNode modifiers = new ModifierListNode(this);
    private final NameNode name = new NameNode(this);

    //TODO: Incomplete

    private final List<AbstractNode<? extends ModuleNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            version,
            modifiers,
            name
    ));

    protected ModuleNode(ClassNode classNode) {
        super(classNode);
    }

    @Override
    public List<AbstractNode<? extends ModuleNode, ?>> children() {
        return children;
    }

    public static class VersionNode extends AbstractValueNode<ModuleNode, VersionNode, Integer> {
        protected VersionNode(ModuleNode moduleNode) {
            super(moduleNode);
        }
    }

    public static class ModifierNode extends AbstractValueNode<ModifierListNode, ModifierNode, Integer> {
        protected ModifierNode(ModifierListNode modifierListNode) {
            super(modifierListNode);
        }
    }

    public static class ModifierListNode extends AbstractListNode<ModuleNode, ModifierListNode, ModifierNode> {
        protected ModifierListNode(ModuleNode moduleNode) {
            super(moduleNode);
        }

        @Override
        protected ModifierNode createEntry(Class<? extends ModifierNode> clazz) {
            return new ModifierNode(this);
        }
    }

    public static class NameNode extends AbstractValueNode<ModuleNode, NameNode, String> {
        protected NameNode(ModuleNode moduleNode) {
            super(moduleNode);
        }
    }
}
