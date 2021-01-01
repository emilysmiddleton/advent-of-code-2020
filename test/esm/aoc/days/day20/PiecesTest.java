package esm.aoc.days.day20;

import esm.aoc.models.grid.Grid;
import esm.aoc.models.grid.MapBackedGrid;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PiecesTest {

    @Test
    void addPiece() {
        Grid<String> grid = new MapBackedGrid<>();
        // ab
        // dc
        grid.addItem(0, 0, "a");
        grid.addItem(1, 0, "b");
        grid.addItem(0, 1, "d");
        grid.addItem(1, 1, "c");
        PuzzlePiece piece = new PuzzlePiece("1", 2, grid);
        Pieces pieces = new Pieces(2, 4, 2, new LinkedHashMap<>());
        pieces.addPiece(piece);
        Set<String> all = pieces.getAllPieces().stream().map(PuzzlePiece::toString).collect(Collectors.toSet());
        assertEquals(8, all.size());
        // a b | d a | c d | b c | b a | a d | d c | c b
        // d c | c b | b a | a d | c d | b c | a b | d a
        assertTrue(all.contains("1\nab\ndc"));
        assertTrue(all.contains("1\nda\ncb"));
        assertTrue(all.contains("1\ncd\nba"));
        assertTrue(all.contains("1\nbc\nad"));
        assertTrue(all.contains("1\nba\ncd"));
        assertTrue(all.contains("1\nad\nbc"));
        assertTrue(all.contains("1\ndc\nab"));
        assertTrue(all.contains("1\ncb\nda"));
    }

    @Test
    void remove() {
        // ab | e f
        // dc | h g
        Grid<String> grid1 = new MapBackedGrid<>();
        // ab
        // dc
        grid1.addItem(0, 0, "a");
        grid1.addItem(1, 0, "b");
        grid1.addItem(0, 1, "d");
        grid1.addItem(1, 1, "c");
        PuzzlePiece piece1 = new PuzzlePiece("1", 2, grid1);
        Grid<String> grid2 = new MapBackedGrid<>();
        // ef
        // hg
        grid2.addItem(0, 0, "e");
        grid2.addItem(1, 0, "f");
        grid2.addItem(0, 1, "h");
        grid2.addItem(1, 1, "g");
        PuzzlePiece piece2 = new PuzzlePiece("2", 2, grid2);

        Pieces pieces = new Pieces(2, 4, 2, new LinkedHashMap<>());
        pieces.addPiece(piece1);
        pieces.addPiece(piece2);
        assertEquals(16, pieces.getAllPieces().size());
        Pieces newPieces = pieces.remove("1");
        assertEquals(8, newPieces.getAllPieces().size());
        assertEquals(8, newPieces.getAllPieces().stream().filter(p -> p.getId().equals("2")).count());
        assertEquals(0, newPieces.getAllPieces().stream().filter(p -> p.getId().equals("1")).count());
    }
}