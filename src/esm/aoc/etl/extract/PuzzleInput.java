package esm.aoc.etl.extract;

import java.util.List;

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
}
