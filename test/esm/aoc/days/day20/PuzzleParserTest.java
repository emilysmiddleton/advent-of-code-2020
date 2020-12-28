package esm.aoc.days.day20;

import esm.aoc.etl.extract.PuzzleInput;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PuzzleParserTest {

    public static final List<String> LINES = List.of(
            "Tile 1951:",
            "#.##...##.",
            "#.####...#",
            ".....#..##",
            "#...######",
            ".##.#....#",
            ".###.#####",
            "###.##.##.",
            ".###....#.",
            "..#.#..#.#",
            "#...##.#..",
            "",
            "Tile 2311:",
            "..##.#..#.",
            "##..#.....",
            "#...##..#.",
            "####.#...#",
            "##.##.###.",
            "##...#.###",
            ".#.#.#..##",
            "..#....#..",
            "###...#.#.",
            "..###..###"
    );

    @Test
    void buildModel() {
        PuzzleInput input = new PuzzleInput(LINES);
        Pieces pieces = new PuzzleParser().buildModel(input);
        Set<PuzzlePiece> all = pieces.getAllPieces();
        assertEquals(16, all.size());
    }
}