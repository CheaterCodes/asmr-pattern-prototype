package org.quiltmc.asmr.tree.instructions;

import org.quiltmc.asmr.tree.AbstractNode;
import org.quiltmc.asmr.tree.AbstractValueNode;
import org.quiltmc.asmr.tree.MethodNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LineNumberNode extends AbstractInstructionNode {
    private final LineNode line = new LineNode(this);
    private final StartNode start = new StartNode(this);

    private final List<AbstractNode<? extends AbstractInstructionNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            line,
            start
    ));
    protected LineNumberNode(MethodNode.InstructionListNode instructionListNode) {
        super(instructionListNode);
    }

    @Override
    public List<AbstractNode<? extends AbstractInstructionNode, ?>> children() {
        return children;
    }

    public static class LineNode extends AbstractValueNode<LineNumberNode, LineNode, Integer> {
        protected LineNode(LineNumberNode lineNumberNode) {
            super(lineNumberNode);
        }
    }

    public static class StartNode extends AbstractValueNode<LineNumberNode, StartNode, LabelNode.Index> {
        protected StartNode(LineNumberNode lineNumberNode) {
            super(lineNumberNode);
        }
    }
}
