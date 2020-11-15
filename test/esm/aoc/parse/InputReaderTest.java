package esm.aoc.parse;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import org.junit.jupiter.api.Test;
import java.util.List;

class InputReaderTest {

    @Test
    void addition() {
        InputReader reader = new InputReader(0);
        List<String> output = reader.read();
        List<String> expected = List.of("This is some", "Test input");
        assertLinesMatch(expected, output);
    }

}
