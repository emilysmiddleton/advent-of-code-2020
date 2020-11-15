package esm.aoc.etl.transform;

import esm.aoc.etl.extract.PuzzleInput;

/**
 * Transforms a the puzzle input into the problem's data model.
 */
public interface Transformer<T> {

    T buildModel(PuzzleInput input);

}
