package esm.aoc.days.day20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PuzzlePieceTest {

    @Test
    void rotate() {
        // ab
        // dc
        PuzzlePiece piece = new PuzzlePiece("1", "ab", "bc", "dc", "ad");
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
        // ab
        // dc
        PuzzlePiece piece = new PuzzlePiece("1", "ab", "bc", "dc", "ad");
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
        // ab
        // dc
        PuzzlePiece piece = new PuzzlePiece("1", "ab", "bc", "dc", "ad");
        // ba
        // cd
        PuzzlePiece flipped = piece.flipVertical();
        assertEquals("ba", flipped.getTop());
        assertEquals("ad", flipped.getRight());
        assertEquals("cd", flipped.getBottom());
        assertEquals("bc", flipped.getLeft());
    }
}