package esm.aoc.etl.transform;

import esm.aoc.etl.extract.PuzzleInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Interprets the puzzle input as a list of numbers, where each line is a single number.
 */
public class IntegersTransformer implements Transformer<List<Integer>> {

    public static IntegersTransformer TO_INTEGERS = new IntegersTransformer();

    @Override
    public List<Integer> buildModel(PuzzleInput input) {
        return input.getLines().stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
