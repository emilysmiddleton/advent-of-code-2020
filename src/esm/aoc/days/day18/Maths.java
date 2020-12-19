package esm.aoc.days.day18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Maths {

    private static final Pattern BRACKETS = Pattern.compile("\\(([^\\(]+?)\\)");
    public static void main(String[] args) {
        System.out.println(new Maths().evaluate("1 + 2 * 3 + 4 * 5 + 6"));
        System.out.println(new Maths().evaluate("1 + (2 * 3) + (4 * (5 + 6))"));
    }

    public long evaluate(String input) {
        Matcher matcher = BRACKETS.matcher(input);
        if (matcher.find()) {
            String group = matcher.group(1);
            long evaluated = evaluate(group);
            String reduced = input.replace("(" + group + ")", Long.toString(evaluated));
            return evaluate(reduced);
        } else {
            return evaluate(input.split(" "));
        }
    }

    public long evaluate(String[] input) {
        long result = Long.parseLong(input[0]);
        for (int i = 1; i < input.length; i += 2) {
            String op = input[i];
            long next = Long.parseLong(input[i + 1]);
            result = "+".equals(op) ? result + next : result * next;
        }
        return result;
    }
}
