package esm.aoc.parse;

import esm.aoc.models.grid.Grid;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GridParserTest {

    @Test
    void parseGridOfCommaSeparatedNumbers() {
        List<String> input = List.of(
                "1,2,3,5",
                "-1,4,6,7"
        );
        GridParser<Integer> parser = new GridParser<>(SeparatedLineParser.COMMA_SEPARATED, Transform.TO_INT);
        Grid<Integer> grid = parser.getGrid(input);

        assertEquals(1, grid.getItem(0, 0));
        assertEquals(2, grid.getItem(1, 0));
        assertEquals(3, grid.getItem(2, 0));
        assertEquals(5, grid.getItem(3, 0));
        assertEquals(-1, grid.getItem(0, 1));
        assertEquals(4, grid.getItem(1, 1));
        assertEquals(6, grid.getItem(2, 1));
        assertEquals(7, grid.getItem(3, 1));
    }
}
