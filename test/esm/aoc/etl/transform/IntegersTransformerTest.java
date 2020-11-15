package esm.aoc.etl.transform;

import esm.aoc.etl.extract.PuzzleInput;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegersTransformerTest {

    @Test
    void parsesEachLineAsAnInteger() {
        IntegersTransformer transformer = new IntegersTransformer();
        PuzzleInput input = new PuzzleInput(List.of("-5", "0", "143"));
        List<Integer> integers = transformer.buildModel(input);
        assertIterableEquals(List.of(-5, 0, 143), integers);
    }

}
