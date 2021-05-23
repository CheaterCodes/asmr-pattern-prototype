package org.quiltmc.asmr.match;

public class StringMatcher extends Matcher<String> {
    public static StringMatcher contains(String substring) {
        return new StringMatcher();
    }

    public static StringMatcher matchContains(String substring) {
        return new StringMatcher();
    }
}
