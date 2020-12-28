package esm.aoc.days.day20;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.models.grid.Coordinate2D;
import esm.aoc.models.grid.Grid;
import esm.aoc.models.grid.MapBackedGrid;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class PartialSolvedPuzzleTest {

    @Test
    void getNextCoordinate() {
        PartialSolvedPuzzle puzzle = new PartialSolvedPuzzle(new Pieces(new LinkedHashMap<>()), new MapBackedGrid<>());
        Grid<PuzzlePiece> grid = puzzle.getPlaced();

        assertEquals(0, puzzle.getSize());
        assertEquals(new Coordinate2D(0, 0), puzzle.getNextCoordinate());

        grid.addItem(0, 0, new PuzzlePiece("1", "a", "a", "a", "a"));
        assertEquals(new Coordinate2D(1, 0), puzzle.getNextCoordinate());
        assertEquals(1, puzzle.getSize());

        grid.addItem(1, 0, new PuzzlePiece("2", "a", "a", "a", "a"));
        assertEquals(new Coordinate2D(2, 0), puzzle.getNextCoordinate());
        assertEquals(2, puzzle.getSize());

        grid.addItem(2, 0, new PuzzlePiece("3", "a", "a", "a", "a"));
        assertEquals(new Coordinate2D(0, 1), puzzle.getNextCoordinate());
        assertEquals(3, puzzle.getSize());

        grid.addItem(0, 1, new PuzzlePiece("4", "a", "a", "a", "a"));
        assertEquals(new Coordinate2D(1, 1), puzzle.getNextCoordinate());
        assertEquals(4, puzzle.getSize());

        grid.addItem(1, 1, new PuzzlePiece("5", "a", "a", "a", "a"));
        assertEquals(new Coordinate2D(2, 1), puzzle.getNextCoordinate());
        assertEquals(5, puzzle.getSize());

        grid.addItem(2, 1, new PuzzlePiece("6", "a", "a", "a", "a"));
        assertEquals(new Coordinate2D(0, 2), puzzle.getNextCoordinate());
        assertEquals(6, puzzle.getSize());

        grid.addItem(0, 2, new PuzzlePiece("7", "a", "a", "a", "a"));
        assertEquals(new Coordinate2D(1, 2), puzzle.getNextCoordinate());
        assertEquals(7, puzzle.getSize());

        grid.addItem(1, 2, new PuzzlePiece("8", "a", "a", "a", "a"));
        assertEquals(new Coordinate2D(2, 2), puzzle.getNextCoordinate());
        assertEquals(8, puzzle.getSize());

        grid.addItem(2, 2, new PuzzlePiece("9", "a", "a", "a", "a"));
        assertEquals(null, puzzle.getNextCoordinate());
        assertEquals(9, puzzle.getSize());
    }

    @Test
    void getNext() {
        Pieces pieces = new PuzzleParser().buildModel(LINES);
        PuzzlePiece first = new PuzzlePiece()
;    }

    @Test
    void placePiece() {
    }

}