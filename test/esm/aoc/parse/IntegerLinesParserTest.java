package esm.aoc.parse;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegerLinesParserTest {

    @Test
    void parsesEachLineAsAnInteger() {
        IntegerLinesParser parser = new IntegerLinesParser();
        List<Integer> integers = parser.parse(List.of("-5", "0", "143"));
        assertIterableEquals(List.of(-5, 0, 143), integers);
    }

}
