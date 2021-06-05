package org.quiltmc.asmr.pattern;

import org.quiltmc.asmr.match.Matcher;

public class ValuePattern<T> extends AbstractPattern<ValuePattern<T>> {
    private final String name;
    private Matcher<T> matcher = null;

    protected ValuePattern(String name, AbstractPattern<?> parent) {
        super(parent);
        this.name = name;
    }

    @Override
    protected ValuePattern<T> create(AbstractPattern<?> parent) {
        return new ValuePattern<>(name, parent);
    }

    public ValuePattern<T> match(Matcher<T> matcher) {
        ValuePattern<T> child = this.create(this);
        child.matcher = matcher;
        return child;
    }
}
