package org.quiltmc.asmr.tree.annotations;

public class LocalVariableAnnotationNode<PARENT, SELF extends LocalVariableAnnotationNode<PARENT, SELF>> extends TypeAnnotationNode<PARENT, SELF> {
    protected LocalVariableAnnotationNode(PARENT parent) {
        super(parent);
    }
}
