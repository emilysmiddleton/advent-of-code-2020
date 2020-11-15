package esm.aoc.parse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * For files that are a list of numbers, parse each line as a number.
 */
public class IntegerLinesParser implements LinesParser<List<Integer>> {

    @Override
    public List<Integer> parse(List<String> lines) {
        return lines.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

}
