package org.quiltmc.asmr.tree.annotations;

public class TypeAnnotationNode<PARENT, SELF extends TypeAnnotationNode<PARENT, SELF>> extends AnnotationNode<PARENT, SELF> {
    protected TypeAnnotationNode(PARENT parent) {
        super(parent);
    }
}
