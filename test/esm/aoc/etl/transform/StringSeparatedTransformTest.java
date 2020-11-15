package esm.aoc.etl.transform;

import esm.aoc.etl.extract.PuzzleInput;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringSeparatedTransformTest {

    @Test
    void commaSeparated() {
        PuzzleInput input = new PuzzleInput(List.of("what,a,lovely,day", "it,is"));
        List<List<String>> parsed = StringSeparatedTransformer.COMMA_SEPARATED.buildModel(input);
        assertEquals(2, parsed.size());
        assertLinesMatch(List.of("what", "a", "lovely", "day"), parsed.get(0));
        assertLinesMatch(List.of("it", "is"), parsed.get(1));
    }

    @Test
    void spaceSeparated() {
        PuzzleInput input = new PuzzleInput(List.of("what a lovely day", "it is"));
        List<List<String>> parsed = new StringSeparatedTransformer(" ").buildModel(input);
        assertLinesMatch(List.of("what", "a", "lovely", "day"), parsed.get(0));
        assertLinesMatch(List.of("it", "is"), parsed.get(1));
    }

    @Test
    void noSeparator() {
        PuzzleInput input = new PuzzleInput(List.of("..#", "#.."));
        List<List<String>> parsed = StringSeparatedTransformer.NO_SEPARATOR.buildModel(input);
        assertLinesMatch(List.of(".", ".", "#"), parsed.get(0));
        assertLinesMatch(List.of("#", ".", "."), parsed.get(1));
    }
}
