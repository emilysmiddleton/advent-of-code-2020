package esm.aoc.days.day02;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.transform.Transformer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Each line in the input is a single integer representing the mass of the module.
 * Convert each line to an integer and wrap in a module.
 */
public class PasswordParser implements Transformer<List<PasswordPolicy>> {

    private static final Pattern PATTERN = Pattern.compile("(\\d+)-(\\d+) ([a-z]): (.+)");
    @Override
    public List<PasswordPolicy> buildModel(PuzzleInput lines) {
        return lines.transform(this::parse);
    }

    private PasswordPolicy parse(String input) {
        Matcher matcher = PATTERN.matcher(input);
        if (matcher.matches()) {
            int first = Integer.parseInt(matcher.group(1));
            int second = Integer.parseInt(matcher.group(2));
            String character = matcher.group(3);
            String password = matcher.group(4);
            return new PasswordPolicy(first, second, character, password);
        }
        throw new Error("Invalid input " + input);
    }
}
