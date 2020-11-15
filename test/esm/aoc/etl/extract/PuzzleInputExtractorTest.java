package esm.aoc.etl.extract;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.util.List;

class PuzzleInputExtractorTest {

    @Test
    void canReadFileAndReturnListOfLines() {
        PuzzleInputExtractor extractor = new PuzzleInputExtractor(0);
        PuzzleInput output = extractor.readLines();
        assertEquals(100, output.getLines().size());
        assertLinesMatch(List.of("142388", "128965"), output.getLines().subList(0, 2));
    }

}
