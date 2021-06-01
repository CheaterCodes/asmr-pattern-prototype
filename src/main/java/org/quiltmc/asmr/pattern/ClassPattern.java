package org.quiltmc.asmr.pattern;

import org.quiltmc.asmr.tree.member.AsmrClassNode;

public class ClassPattern extends Pattern<AsmrClassNode> {
    private ValuePattern<String> name = new ValuePattern<>("name");
    private ValuePattern<String> superclass = new ValuePattern<>("superclass");

    private SlicePattern<MethodPattern> methods = new SlicePattern<>(MethodPattern::new);

    public ClassPattern() {
    }

    public ValuePattern<String> name() {
        return name;
    }

    public ValuePattern<String> superclass() {
        return superclass;
    }

    public SlicePattern<MethodPattern> methods() {
        return methods;
    }
}
