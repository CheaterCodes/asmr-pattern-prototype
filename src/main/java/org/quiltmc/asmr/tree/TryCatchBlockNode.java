package org.quiltmc.asmr.tree;

import org.quiltmc.asmr.tree.annotations.TypeAnnotationNode;
import org.quiltmc.asmr.tree.instructions.LabelNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TryCatchBlockNode extends AbstractNode<MethodNode.TryCatchBlockListNode, TryCatchBlockNode> {
    private final StartNode start = new StartNode(this);
    private final EndNode end = new EndNode(this);
    private final HandlerNode handler = new HandlerNode(this);

    private final TypeNode type = new TypeNode(this);

    private final VisibleTypeAnnotationListNode visibleTypeAnnotations = new VisibleTypeAnnotationListNode(this);
    private final InvisibleTypeAnnotationListNode invisibleTypeAnnotations = new InvisibleTypeAnnotationListNode(this);

    private final List<AbstractNode<? extends TryCatchBlockNode, ?>> children = Collections.unmodifiableList(Arrays.asList(
            start,
            end,
            handler,
            type,
            visibleTypeAnnotations,
            invisibleTypeAnnotations
    ));

    protected TryCatchBlockNode(MethodNode.TryCatchBlockListNode tryCatchBlockListNode) {
        super(tryCatchBlockListNode);
    }

    @Override
    public List<AbstractNode<? extends TryCatchBlockNode, ?>> children() {
        return children;
    }
    
    public static class TypeNode extends AbstractValueNode<TryCatchBlockNode, TypeNode, String> {
        protected TypeNode(TryCatchBlockNode tryCatchBlockNode) {
            super(tryCatchBlockNode);
        }
    }

    public static class StartNode extends AbstractValueNode<TryCatchBlockNode, StartNode, LabelNode.Index> {
        protected StartNode(TryCatchBlockNode tryCatchBlockNode) {
            super(tryCatchBlockNode);
        }
    }

    public static class EndNode extends AbstractValueNode<TryCatchBlockNode, EndNode, LabelNode.Index> {
        protected EndNode(TryCatchBlockNode tryCatchBlockNode) {
            super(tryCatchBlockNode);
        }
    }

    public static class HandlerNode extends AbstractValueNode<TryCatchBlockNode, HandlerNode, LabelNode.Index> {
        protected HandlerNode(TryCatchBlockNode tryCatchBlockNode) {
            super(tryCatchBlockNode);
        }
    }

    public static class VisibleTypeAnnotationNode extends TypeAnnotationNode<VisibleTypeAnnotationListNode, VisibleTypeAnnotationNode> {
        protected VisibleTypeAnnotationNode(VisibleTypeAnnotationListNode visibleTypeAnnotationListNode) {
            super(visibleTypeAnnotationListNode);
        }
    }

    public static class VisibleTypeAnnotationListNode extends AbstractListNode<TryCatchBlockNode, VisibleTypeAnnotationListNode, VisibleTypeAnnotationNode> {
        protected VisibleTypeAnnotationListNode(TryCatchBlockNode tryCatchBlockNode) {
            super(tryCatchBlockNode);
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

    public static class InvisibleTypeAnnotationListNode extends AbstractListNode<TryCatchBlockNode, InvisibleTypeAnnotationListNode, InvisibleTypeAnnotationNode> {
        protected InvisibleTypeAnnotationListNode(TryCatchBlockNode tryCatchBlockNode) {
            super(tryCatchBlockNode);
        }

        @Override
        protected InvisibleTypeAnnotationNode createEntry(Class<? extends InvisibleTypeAnnotationNode> clazz) {
            return new InvisibleTypeAnnotationNode(this);
        }
    }
}
