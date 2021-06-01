package org.quiltmc.asmr.pattern;

import org.quiltmc.asmr.tree.member.AsmrMethodNode;

public class MethodPattern extends Pattern<AsmrMethodNode> {
    private ValuePattern<String> name = new ValuePattern<>("name");

    protected MethodPattern() {
    }

    public ValuePattern<String> name() {
        return name;
    }
}
