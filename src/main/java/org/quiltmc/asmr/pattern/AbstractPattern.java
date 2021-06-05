package org.quiltmc.asmr.pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class AbstractPattern<SELF extends AbstractPattern<SELF>> {
    private static final Map<Class<?>, Function<AbstractPattern<?>, ? extends AbstractPattern<?>>> TYPES = new HashMap<>();

    protected final AbstractPattern<?> parent;
    protected AbstractPattern<?> child = null;

    protected AbstractPattern(AbstractPattern<?> parent) {
        this.parent = parent;
    }

    protected static <T extends AbstractPattern<T>> void register(Class<T> clazz, Function<AbstractPattern<?>, T> ctor) {
        TYPES.put(clazz, ctor);
    }

    @SuppressWarnings("unchecked")
    protected final SELF getThis() {
        return (SELF) this;
    }

    protected abstract SELF create(AbstractPattern<?> parent);

    public final SELF filter(Function<SELF, AbstractPattern<?>> childProvider) {
        AbstractPattern<?> child = childProvider.apply(getThis());
        if (!child.isChildOf(this)) {
            throw new IllegalArgumentException("Provided child is not a child of this pattern");
        }

        SELF clone = this.create(this);
        clone.child = child;
        return clone;
    }

    public <T extends AbstractPattern<?>> T as(Class<T> type) {
        Function<AbstractPattern<?>, ? extends AbstractPattern<?>> ctor = TYPES.get(type);
        if (ctor == null) {
            throw new IllegalArgumentException("Unknown class " + type);
        }
        //noinspection unchecked
        return (T) ctor.apply(this);
    }

    protected final boolean isChildOf(AbstractPattern<?> parent) {
        return this.parent != null && (this.parent == parent || this.parent.isChildOf(parent));
    }
}
