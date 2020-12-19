package esm.aoc.days.day18;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Maths {

    private static final Pattern BRACKETS = Pattern.compile("\\(([^(]+?)\\)");
    private static final Pattern PLUS = Pattern.compile("\\d+ \\+ \\d+");
    public static void main(String[] args) {
        //       System.out.println(new Maths(true).evaluate("1 + 2 * 3 + 4 * 5 + 6"));
//        System.out.println(new Maths(true).evaluate("1 + (2 * 3) + (4 * (5 + 6))"));
//        System.out.println(new Maths(true).evaluate("2 * 3 + (4 * 5)"));
//        System.out.println(new Maths(true).evaluate("5 + (8 * 3 + 9 + 3 * 4 * 3)"));
        System.out.println(new Maths(true).evaluate("6 + 2 * 7 * 4 * 6 + 20250"));

        // System.out.println(new Maths(true).evaluate("7 * 3 * 3 + 9 * 3 + 56"));
        // System.out.println(new Maths(true).evaluate("7 * 3 * 3 + 9 * 3 + (8 + 6 * 4)"));
        // System.out.println(new Maths(true).evaluate("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"));
//        System.out.println(new Maths(true).evaluate("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"));
    }

    private final boolean addFirst;

    public Maths(boolean addFirst) {
        this.addFirst = addFirst;
    }

    public BigInteger evaluate(String input) {
        Matcher matcher = BRACKETS.matcher(input);
        if (matcher.find()) {
            String group = matcher.group(1);
            BigInteger evaluated = evaluate(group);
            String reduced = input.replace("(" + group + ")", evaluated.toString());
            return evaluate(reduced);
        } else {
            if (addFirst && input.contains("+") && input.contains("*")) {
                Matcher plusMatcher = PLUS.matcher(input);
                if (plusMatcher.find()) {
                    String group = plusMatcher.group(0);
                    BigInteger evaluated = evaluate(group);
                    String reduced = input.replaceFirst(Pattern.quote(group), evaluated.toString());
                    return evaluate(reduced);
                }
            }
            return evaluate(input.split(" +"));
        }
    }

    public BigInteger evaluate(String[] input) {
        BigInteger result = new BigInteger(input[0]);
        for (int i = 1; i < input.length; i += 2) {
            String op = input[i];
            BigInteger next = new BigInteger(input[i + 1]);
            result = "+".equals(op) ? result.add(next) : result.multiply(next);
        }
        return result;
    }
}
