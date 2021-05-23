package org.quiltmc.asmr.tree.annotations;

import org.quiltmc.asmr.tree.AbstractListNode;
import org.quiltmc.asmr.tree.AbstractNode;
import org.quiltmc.asmr.tree.AbstractValueNode;

import java.util.List;

public class AnnotationNode<PARENT, SELF extends AnnotationNode<PARENT, SELF>> extends AbstractNode<PARENT, SELF> {
    private DescriptorNode<PARENT, SELF> descriptor = new DescriptorNode<>(getThis());

    protected AnnotationNode(PARENT parent) {
        super(parent);
    }

    @Override
    public List<AbstractNode<? extends SELF, ?>> children() {
        throw new UnsupportedOperationException(/*TODO*/);
    }

    public static class DescriptorNode<ANNOTATION_PARENT, ANNOTATION extends AnnotationNode<ANNOTATION_PARENT, ANNOTATION>>
            extends AbstractValueNode<ANNOTATION, DescriptorNode<ANNOTATION_PARENT, ANNOTATION>, String> {
        protected DescriptorNode(ANNOTATION annotation) {
            super(annotation);
        }
    }

    public static class EntryNode<ANNOTATION_PARENT, ANNOTATION extends AnnotationNode<ANNOTATION_PARENT, ANNOTATION>>
            extends AbstractValueNode<AnnotationEntryListNode<ANNOTATION_PARENT, ANNOTATION>, EntryNode<ANNOTATION_PARENT, ANNOTATION>, String> {
        private NameNode<ANNOTATION_PARENT, ANNOTATION> name = new NameNode<>(this);

        protected EntryNode(AnnotationEntryListNode<ANNOTATION_PARENT, ANNOTATION> parent) {
            super(parent);
        }

        public static class NameNode<ANNOTATION_PARENT, ANNOTATION extends AnnotationNode<ANNOTATION_PARENT, ANNOTATION>>
                extends AbstractValueNode<AnnotationNode.EntryNode<ANNOTATION_PARENT, ANNOTATION>, NameNode<ANNOTATION_PARENT, ANNOTATION>, String> {
            protected NameNode(AnnotationNode.EntryNode<ANNOTATION_PARENT, ANNOTATION> parent) {
                super(parent);
            }
        }

        public static class ValueNode<ANNOTATION_PARENT, ANNOTATION extends AnnotationNode<ANNOTATION_PARENT, ANNOTATION>, TYPE>
                extends AbstractValueNode<AnnotationNode.EntryNode<ANNOTATION_PARENT, ANNOTATION>, ValueNode<ANNOTATION_PARENT, ANNOTATION, TYPE>, TYPE> {
            protected ValueNode(AnnotationNode.EntryNode<ANNOTATION_PARENT, ANNOTATION> parent) {
                super(parent);
            }
        }
    }

    public static class AnnotationEntryListNode<ANNOTATION_PARENT, ANNOTATION extends AnnotationNode<ANNOTATION_PARENT, ANNOTATION>>
            extends AbstractListNode<ANNOTATION, AnnotationEntryListNode<ANNOTATION_PARENT, ANNOTATION>, EntryNode<ANNOTATION_PARENT, ANNOTATION>> {
        protected AnnotationEntryListNode(ANNOTATION annotation) {
            super(annotation);
        }

        @Override
        protected EntryNode<ANNOTATION_PARENT, ANNOTATION> createEntry(Class<? extends EntryNode<ANNOTATION_PARENT, ANNOTATION>> clazz) {
            throw new UnsupportedOperationException(/*TODO*/);
        }
    }
}
