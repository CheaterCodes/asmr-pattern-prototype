package org.quiltmc.amsr.pattern;

import org.junit.jupiter.api.Test;
import org.objectweb.asm.Opcodes;
import org.quiltmc.asmr.match.Matcher;
import org.quiltmc.asmr.pattern.ClassPattern;
import org.quiltmc.asmr.pattern.MethodInstructionPattern;

public class BasicPatternTests {
    @Test
    public void classPattern() {
        ClassPattern.ALL.filter(c -> c.name().match(Matcher.exact("/org/example/ClassName")));
    }

    @Test
    public void methodPattern() {
        ClassPattern.ALL.methods().filter(m -> m.name().match(Matcher.exact("methodName")));
    }

    @Test
    public void instructionNodePattern() {
        ClassPattern.ALL
                .methods()
                .filter(m -> m.name().match(Matcher.exact("methodName")))
                .body().instructions()
                .filter(i -> i.opcode().match(Matcher.exact(Opcodes.LDC)));
    }

    @Test
    public void methodInstructionNodePattern() {
        ClassPattern.ALL
                .methods()
                .filter(m -> m.name().match(Matcher.exact("methodName")))
                .body().instructions()
                .as(MethodInstructionPattern.class)
                .filter(i -> i.name().match(Matcher.exact("getBlockState")));
    }

    @Test
    public void instructionSlicePattern() {
        ClassPattern.ALL
                .methods()
                .filter(m -> m.name().match(Matcher.exact("methodName")))
                .body().instructions()
                .slice(
                        i -> i.filterInstruction().filter(j -> j.opcode().match(Matcher.exact(Opcodes.IFEQ))).first(),
                        i -> i.filterInstruction().filter(j -> j.opcode().match(Matcher.exact(Opcodes.JSR))).last()
                );
    }
}
