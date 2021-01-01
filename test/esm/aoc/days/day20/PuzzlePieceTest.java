package esm.aoc.days.day20;

import esm.aoc.models.grid.Grid;
import esm.aoc.models.grid.MapBackedGrid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PuzzlePieceTest {

    @Test
    void rotate() {
        Grid<String> grid = new MapBackedGrid<>();
        // ab
        // dc
        grid.addItem(0, 0, "a");
        grid.addItem(1, 0, "b");
        grid.addItem(0, 1, "d");
        grid.addItem(1, 1, "c");
        PuzzlePiece piece = new PuzzlePiece("1", 2, grid);
        // da
        // cb
        PuzzlePiece rotated = piece.rotate();
        assertEquals("da", rotated.getTop());
        assertEquals("ab", rotated.getRight());
        assertEquals("cb", rotated.getBottom());
        assertEquals("dc", rotated.getLeft());
    }

    @Test
    void flipHorizontal() {
        Grid<String> grid = new MapBackedGrid<>();
        // ab
        // dc
        grid.addItem(0, 0, "a");
        grid.addItem(1, 0, "b");
        grid.addItem(0, 1, "d");
        grid.addItem(1, 1, "c");
        PuzzlePiece piece = new PuzzlePiece("1", 2, grid);
        // dc
        // ab
        PuzzlePiece flipped = piece.flipHorizontal();
        assertEquals("dc", flipped.getTop());
        assertEquals("cb", flipped.getRight());
        assertEquals("ab", flipped.getBottom());
        assertEquals("da", flipped.getLeft());
    }

    @Test
    void flipVertical() {
        Grid<String> grid = new MapBackedGrid<>();
        // ab
        // dc
        grid.addItem(0, 0, "a");
        grid.addItem(1, 0, "b");
        grid.addItem(0, 1, "d");
        grid.addItem(1, 1, "c");
        PuzzlePiece piece = new PuzzlePiece("1", 2, grid);
        // ba
        // cd
        PuzzlePiece flipped = piece.flipVertical();
        assertEquals("ba", flipped.getTop());
        assertEquals("ad", flipped.getRight());
        assertEquals("cd", flipped.getBottom());
        assertEquals("bc", flipped.getLeft());
    }
}