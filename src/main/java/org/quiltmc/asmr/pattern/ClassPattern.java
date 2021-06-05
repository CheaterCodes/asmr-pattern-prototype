package org.quiltmc.asmr.pattern;

public class ClassPattern extends AbstractPattern<ClassPattern> {
    public static final ClassPattern ALL = new ClassPattern(null);

    protected ClassPattern(AbstractPattern<?> parent) {
        super(parent);
    }

    @Override
    protected ClassPattern create(AbstractPattern<?> parent) {
        return new ClassPattern(parent);
    }

    public ValuePattern<String> name() {
        return new ValuePattern<>("name", this);
    }

    public ValuePattern<String> superclass() {
        return new ValuePattern<>("superclass", this);
    }

    public MethodPattern methods() {
        return new MethodPattern(this);
    }
}
