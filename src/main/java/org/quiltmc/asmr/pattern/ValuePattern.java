package org.quiltmc.asmr.pattern;

import org.quiltmc.asmr.match.Matcher;

public class ValuePattern<T> extends Pattern<ValuePattern<T>> {
    private final String name;
    private Matcher<T> matcher = null;

    protected ValuePattern(String name, Pattern<?> parent) {
        super(parent);
        this.name = name;
    }

    @Override
    protected ValuePattern<T> create(Pattern<?> parent) {
        return new ValuePattern<>(name, parent);
    }

    public ValuePattern<T> match(Matcher<T> matcher) {
        ValuePattern<T> child = this.create(this);
        child.matcher = matcher;
        return child;
    }
}
