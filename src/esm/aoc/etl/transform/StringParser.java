package esm.aoc.etl.transform;

/**
 * Takes a string representation of something and returns an object.
 */
public interface StringParser<T> {

    StringParser<Integer> TO_INT = Integer::parseInt;

    T transform(String input);

}

