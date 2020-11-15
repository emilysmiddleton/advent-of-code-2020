package esm.aoc.parse;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.List;

class InputReaderTest {

    @Test
    void canReadFileAndReturnListOfLines() {
        InputReader reader = new InputReader(0);
        List<String> output = reader.read();
        assertEquals(100, output.size());
        assertLinesMatch(List.of("142388", "128965"), output.subList(0, 2));
    }

}
