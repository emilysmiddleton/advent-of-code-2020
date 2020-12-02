package esm.aoc.etl.extract;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Puzzles are usually a list of strings in a text file.
 */
public class PuzzleInput {

    private final List<String> lines;

    public PuzzleInput(List<String> lines) {
        this.lines = lines;
    }

    public List<String> getLines() {
        return lines;
    }

    public <T> List<T> transform(Function<String, T> mapper) {
        return lines.stream().map(mapper).collect(Collectors.toList());
    }
}
