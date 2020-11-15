package esm.aoc.parse;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeparatedLineParserTest {

    @Test
    void commaSeparated() {
        List<String> input = List.of("what,a,lovely,day", "it,is");
        List<List<String>> parsed = SeparatedLineParser.COMMA_SEPARATED.parse(input);
        assertEquals(2, parsed.size());
        assertLinesMatch(List.of("what", "a", "lovely", "day"), parsed.get(0));
        assertLinesMatch(List.of("it", "is"), parsed.get(1));
    }

    @Test
    void spaceSeparated() {
        List<String> input = List.of("what a lovely day", "it is");
        List<List<String>> parsed = new SeparatedLineParser(" ").parse(input);
        assertLinesMatch(List.of("what", "a", "lovely", "day"), parsed.get(0));
        assertLinesMatch(List.of("it", "is"), parsed.get(1));
    }

    @Test
    void noSeparator() {
        List<String> input = List.of("..#", "#..");
        List<List<String>> parsed = SeparatedLineParser.NO_SEPARATOR.parse(input);
        assertLinesMatch(List.of(".", ".", "#"), parsed.get(0));
        assertLinesMatch(List.of("#", ".", "."), parsed.get(1));
    }
}
