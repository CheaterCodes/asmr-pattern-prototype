package org.quiltmc.amsr.pattern;

import org.junit.jupiter.api.Test;
import org.quiltmc.asmr.match.Matcher;
import org.quiltmc.asmr.pattern.ClassPattern;
import org.quiltmc.asmr.pattern.MethodPattern;
import org.quiltmc.asmr.pattern.SlicePattern;

public class BasicPatternTests {
    @Test
    public void classPattern() {
        ClassPattern classPattern = new ClassPattern();
        classPattern.name().match(Matcher.exact("org/test/Name"));
    }

    @Test
    public void methodPattern() {
        ClassPattern classPattern = new ClassPattern();
        SlicePattern<MethodPattern> methods = classPattern.methods();

        MethodPattern method = methods.first();
        method.name().match(Matcher.exact("methodName"));
    }

    @Test
    public void instructionNodePattern() {
    }

    @Test
    public void methodInstructionNodePattern() {
    }

    @Test
    public void instructionSlicePattern() {
    }
}
