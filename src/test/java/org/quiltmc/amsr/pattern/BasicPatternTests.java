package org.quiltmc.amsr.pattern;

import org.junit.jupiter.api.Test;
import org.objectweb.asm.Opcodes;
import org.quiltmc.asmr.match.Matcher;
import org.quiltmc.asmr.pattern.NodePattern;
import org.quiltmc.asmr.pattern.SlicePattern;
import org.quiltmc.asmr.pattern.ValuePattern;
import org.quiltmc.asmr.tree.ClassNode;
import org.quiltmc.asmr.tree.MethodNode;
import org.quiltmc.asmr.tree.VoidNode;
import org.quiltmc.asmr.tree.instructions.AbstractInstructionNode;
import org.quiltmc.asmr.tree.instructions.NoOperandInstructionNode;

public class BasicPatternTests {
    @Test
    public void classNodePattern() {
        ValuePattern<ClassNode, ClassNode.NameNode, String> classNamePattern =
                new ValuePattern<>(ClassNode.NameNode.class)
                        .match(Matcher.exact("/pkg/ClassName"));

        NodePattern<VoidNode, ClassNode> classPattern =
                new NodePattern<>(ClassNode.class)
                        .child(classNamePattern);
    }

    @Test
    public void methodNodePattern() {
        ValuePattern<ClassNode, ClassNode.NameNode, String> classNamePattern =
                new ValuePattern<>(ClassNode.NameNode.class)
                        .match(Matcher.exact("/pkg/ClassName"));

        NodePattern<VoidNode, ClassNode> classPattern =
                new NodePattern<>(ClassNode.class)
                        .child(classNamePattern);

        NodePattern<ClassNode, ClassNode.MethodListNode> methodListPattern =
                new NodePattern<>(ClassNode.MethodListNode.class);

        ValuePattern<MethodNode, MethodNode.NameNode, String> methodNamePattern =
                new ValuePattern<>(MethodNode.NameNode.class)
                        .match(Matcher.exact("methodName"));

        ValuePattern<MethodNode, MethodNode.DescriptorNode, String> methodDescPattern =
                new ValuePattern<>(MethodNode.DescriptorNode.class)
                        .match(Matcher.exact("()V"));

        NodePattern<ClassNode.MethodListNode, MethodNode> methodPattern =
                (new NodePattern<>(MethodNode.class)
                        .child(methodNamePattern)
                        .child(methodDescPattern))
                        .parent(methodListPattern);
    }

    @Test
    public void instructionNodePattern() {
        ValuePattern<AbstractInstructionNode, AbstractInstructionNode.OpcodeNode, Integer> opcodePattern =
                new ValuePattern<>(AbstractInstructionNode.OpcodeNode.class)
                        .match(Matcher.any(Matcher.exact(Opcodes.RETURN), Matcher.exact(Opcodes.ARETURN)));

        NodePattern<MethodNode.InstructionListNode, NoOperandInstructionNode> pattern =
                new NodePattern<>(NoOperandInstructionNode.class).child(opcodePattern);
    }

    @Test
    public void instructionSlicePattern() {
        ValuePattern<AbstractInstructionNode, AbstractInstructionNode.OpcodeNode, Integer> startOpcodePattern =
                new ValuePattern<>(AbstractInstructionNode.OpcodeNode.class)
                        .match(Matcher.exact(Opcodes.ALOAD));

        NodePattern<MethodNode.InstructionListNode, NoOperandInstructionNode> startPattern =
                new NodePattern<>(NoOperandInstructionNode.class).child(startOpcodePattern);


        ValuePattern<AbstractInstructionNode, AbstractInstructionNode.OpcodeNode, Integer> endOpcodePattern =
                new ValuePattern<>(AbstractInstructionNode.OpcodeNode.class)
                        .match(Matcher.exact(Opcodes.ASTORE));

        NodePattern<MethodNode.InstructionListNode, NoOperandInstructionNode> endPattern =
                new NodePattern<>(NoOperandInstructionNode.class).child(endOpcodePattern);

        SlicePattern<MethodNode, MethodNode.InstructionListNode, AbstractInstructionNode> slicePattern =
                new SlicePattern<>(MethodNode.InstructionListNode.class)
                        .after(startPattern, false)
                        .before(endPattern, true);
    }
}
