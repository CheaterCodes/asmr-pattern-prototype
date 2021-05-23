package org.quiltmc.asmr.tree.instructions;

import org.quiltmc.asmr.tree.AbstractListNode;
import org.quiltmc.asmr.tree.AbstractNode;
import org.quiltmc.asmr.tree.AbstractValueNode;
import org.quiltmc.asmr.tree.MethodNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SwitchInstructionNode extends InstructionNode {
    private final DefaultLabelNode defaultLabel = new DefaultLabelNode(this);
    private final KeyLabelListNode labels = new KeyLabelListNode(this);

    private final List<AbstractNode<? extends AbstractInstructionNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            visibleAnnotations(),
            invisibleAnnotations(),
            opcode(),
            defaultLabel,
            labels
    ));
    
    protected SwitchInstructionNode(MethodNode.InstructionListNode instructionListNode) {
        super(instructionListNode);
    }

    @Override
    public List<AbstractNode<? extends AbstractInstructionNode, ?>> children() {
        return children;
    }

    public static class DefaultLabelNode extends AbstractValueNode<SwitchInstructionNode, DefaultLabelNode, LabelNode.Index> {
        protected DefaultLabelNode(SwitchInstructionNode switchInstructionNode) {
            super(switchInstructionNode);
        }
    }

    public static class KeyLabelNode extends AbstractNode<KeyLabelListNode, KeyLabelNode> {
        private final KeyNode key = new KeyNode(this);
        private final LabelNode label = new LabelNode(this);

        private final List<AbstractNode<? extends KeyLabelNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
                key,
                label
        ));

        protected KeyLabelNode(KeyLabelListNode keyLabelListNode) {
            super(keyLabelListNode);
        }

        @Override
        public List<AbstractNode<? extends KeyLabelNode, ?>> children() {
            return children;
        }

        public static class KeyNode extends AbstractValueNode<KeyLabelNode, KeyNode, Integer> {
            protected KeyNode(KeyLabelNode keyLabelNode) {
                super(keyLabelNode);
            }
        }

        public static class LabelNode extends AbstractValueNode<KeyLabelNode, LabelNode, org.quiltmc.asmr.tree.instructions.LabelNode.Index> {
            protected LabelNode(KeyLabelNode keyLabelNode) {
                super(keyLabelNode);
            }
        }
    }

    public static class KeyLabelListNode extends AbstractListNode<SwitchInstructionNode, KeyLabelListNode, KeyLabelNode> {
        protected KeyLabelListNode(SwitchInstructionNode switchInstructionNode) {
            super(switchInstructionNode);
        }

        @Override
        protected KeyLabelNode createEntry(Class<? extends KeyLabelNode> clazz) {
            return new KeyLabelNode(this);
        }
    }
}
