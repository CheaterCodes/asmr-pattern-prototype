package org.quiltmc.asmr.tree;

import org.quiltmc.asmr.tree.instructions.LabelNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LocalVariableNode extends AbstractNode<MethodNode.LocalVariableListNode, LocalVariableNode>{
    private final NameNode name = new NameNode(this);
    private final DescriptorNode descriptor = new DescriptorNode(this);
    private final SignatureNode signature = new SignatureNode(this);

    private final StartNode start = new StartNode(this);
    private final EndNode end = new EndNode(this);
    private final IndexNode index = new IndexNode(this);

    private final List<AbstractNode<? extends LocalVariableNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            name,
            descriptor,
            signature,
            start,
            end,
            index
    ));

    protected LocalVariableNode(MethodNode.LocalVariableListNode localVariableListNode) {
        super(localVariableListNode);
    }

    @Override
    public List<AbstractNode<? extends LocalVariableNode, ?>> children() {
        return children;
    }

    public static class Index {}

    public static class NameNode extends AbstractValueNode<LocalVariableNode, NameNode, String> {
        protected NameNode(LocalVariableNode localVariableNode) {
            super(localVariableNode);
        }
    }

    public static class DescriptorNode extends AbstractValueNode<LocalVariableNode, DescriptorNode, String> {
        protected DescriptorNode(LocalVariableNode localVariableNode) {
            super(localVariableNode);
        }
    }

    public static class SignatureNode extends AbstractValueNode<LocalVariableNode, SignatureNode, String> {
        protected SignatureNode(LocalVariableNode localVariableNode) {
            super(localVariableNode);
        }
    }

    public static class StartNode extends AbstractValueNode<LocalVariableNode, StartNode, LabelNode.Index> {
        protected StartNode(LocalVariableNode localVariableNode) {
            super(localVariableNode);
        }
    }

    public static class EndNode extends AbstractValueNode<LocalVariableNode, EndNode, LabelNode.Index> {
        protected EndNode(LocalVariableNode localVariableNode) {
            super(localVariableNode);
        }
    }

    public static class IndexNode extends AbstractValueNode<LocalVariableNode, IndexNode, Index> {
        protected IndexNode(LocalVariableNode localVariableNode) {
            super(localVariableNode);
        }
    }
}
