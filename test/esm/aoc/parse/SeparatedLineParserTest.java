package esm.aoc.parse;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeparatedLineParserTest {

    @Test
    void commaSeparated() {
        List<String> input = List.of("what,a,lovely,day");
        List<String> parsed = SeparatedLineParser.COMMA_SEPARATED.parse(input);
        assertLinesMatch(List.of("what", "a", "lovely", "day"), parsed);
    }

    @Test
    void spaceSeparated() {
        List<String> input = List.of("what a lovely day");
        List<String> parsed = new SeparatedLineParser(" ").parse(input);
        assertLinesMatch(List.of("what", "a", "lovely", "day"), parsed);
    }
}
