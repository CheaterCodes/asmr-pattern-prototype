package org.quiltmc.asmr.match;

public abstract class Matcher<T> {
    /**
     * Performs equality check via {@link Object#equals(Object)}.
     * @param value The value to compare with
     * @param <T> The type to match
     * @return A matcher checking for equality
     */
    public static <T> Matcher<T> exact(T value) {
        return new Matcher<T>() {};
    }

    /**
     * Matches if at least one of the specified {@link Matcher Matchers} matches.
     * @param matchers The list of {@link Matcher Matchers} to check
     * @param <T> The type to match
     * @return A matcher checking if any of the specified matchers match
     */
    @SafeVarargs
    public static <T> Matcher<T> any(Matcher<T>... matchers) {
        // TODO: Ensure safe varargs
        return new Matcher<T>() {};
    }

    /**
     * Matches if all of the specified {@link Matcher Matchers} match.
     * @param matchers The list of {@link Matcher Matchers} to check
     * @param <T> The type to match
     * @return A matcher checking if all of the specified matchers match
     */
    @SafeVarargs
    public static <T> Matcher<T> all(Matcher<T>... matchers) {
        // TODO: Ensure safe varargs
        return new Matcher<T>() {};
    }
}
