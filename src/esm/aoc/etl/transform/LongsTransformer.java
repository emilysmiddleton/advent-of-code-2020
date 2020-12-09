package esm.aoc.etl.transform;

import esm.aoc.etl.extract.PuzzleInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Interprets the puzzle input as a list of numbers, where each line is a single number.
 */
public class LongsTransformer implements Transformer<List<Long>> {

    public static LongsTransformer TO_LONGS = new LongsTransformer();

    @Override
    public List<Long> buildModel(PuzzleInput input) {
        return input.getLines().stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

}
