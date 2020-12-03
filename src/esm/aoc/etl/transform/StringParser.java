package esm.aoc.etl.transform;

/**
 * Takes a string representation of something and returns an object.
 */
public interface StringParser<T> {

    StringParser<Integer> TO_INT = Integer::parseInt;
    StringParser<String> PASS_THROUGH = String::toString;

    T transform(String input);

}

