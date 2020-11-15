package esm.aoc.etl.transform;

import esm.aoc.etl.extract.PuzzleInput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Interprets the puzzle input as a list of lists, where each line is separated by a character.
 */
public class StringSeparatedTransformer implements Transformer<List<List<String>>> {

    public static final StringSeparatedTransformer COMMA_SEPARATED = new StringSeparatedTransformer(",");
    public static final StringSeparatedTransformer NO_SEPARATOR = new StringSeparatedTransformer("");

    private final String separator;

    public StringSeparatedTransformer(String separator) {
        this.separator = separator;
    }

    @Override
    public List<List<String>> buildModel(PuzzleInput input) {
        return input.getLines().stream().map(this::parseLine).collect(Collectors.toList());
    }

    private List<String> parseLine(String line) {
        return Arrays.asList(line.split(separator));
    }

}
