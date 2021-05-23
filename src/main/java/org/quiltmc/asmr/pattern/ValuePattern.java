package org.quiltmc.asmr.pattern;

import org.quiltmc.asmr.match.Matcher;
import org.quiltmc.asmr.tree.AbstractValueNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValuePattern<P, N extends AbstractValueNode<P, ? extends N, T>, T> extends AbstractPattern<P, N, ValuePattern<P, N, T>> {
    private List<Matcher<T>> matchers = Collections.emptyList();

    public ValuePattern(Class<? extends N> nodeClass) {
        super(nodeClass);
    }

    @Override
    protected ValuePattern<P, N, T> newInstance() {
        return new ValuePattern<>(nodeClass);
    }

    @Override
    protected void copyFrom(ValuePattern<P, N, T> pattern) {
        super.copyFrom(pattern);
        this.matchers = new ArrayList<>(pattern.matchers);
    }

    public ValuePattern<P, N, T> match(Matcher<T> matcher) {
        ValuePattern<P, N, T> newPattern = newInstance();
        newPattern.copyFrom(getThis());
        newPattern.matchers.add(matcher);
        return newPattern;
    }
}
