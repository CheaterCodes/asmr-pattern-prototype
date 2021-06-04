package org.quiltmc.amsr.pattern;

import org.junit.jupiter.api.Test;
import org.objectweb.asm.Opcodes;
import org.quiltmc.asmr.match.Matcher;
import org.quiltmc.asmr.pattern.ClassPattern;

public class BasicPatternTests {
    @Test
    public void classPattern() {
        ClassPattern.ALL.with(c -> c.name().match(Matcher.exact("/org/example/ClassName")));
    }

    @Test
    public void methodPattern() {
        ClassPattern.ALL.methods().with(m -> m.name().match(Matcher.exact("methodName")));
    }

    @Test
    public void instructionNodePattern() {
        ClassPattern.ALL
                .methods()
                .with(m -> m.name().match(Matcher.exact("methodName")))
                .body().instructions().insn()
                .with(i -> i.opcode().match(Matcher.exact(Opcodes.LDC)));
    }

    @Test
    public void methodInstructionNodePattern() {
        ClassPattern.ALL
                .methods()
                .with(m -> m.name().match(Matcher.exact("methodName")))
                .body().instructions().insn()
                .methodInstruction()
                .with(i -> i.name().match(Matcher.exact("getBlockState")));
    }

    @Test
    public void instructionSlicePattern() {
        ClassPattern.ALL
                .methods()
                .with(m -> m.name().match(Matcher.exact("methodName")))
                .body().instructions()
                .slice(
                        i -> i.insn().with(j -> j.opcode().match(Matcher.exact(Opcodes.IFEQ))).first(),
                        i -> i.insn().with(j -> j.opcode().match(Matcher.exact(Opcodes.JSR))).first()
                );
    }
}
