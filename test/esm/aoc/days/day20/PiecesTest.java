package esm.aoc.days.day20;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PiecesTest {

    @Test
    void addPiece() {
        // ab
        // dc
        PuzzlePiece piece = new PuzzlePiece("1", "ab", "bc", "dc", "ad");
        Pieces pieces = new Pieces(new LinkedHashMap<>());
        pieces.addPiece(piece);
        Set<PuzzlePiece> all = pieces.getAllPieces();
        assertEquals(8, all.size());
        // a b | d a | c d | b c | b a | a d | d c | c b
        // d c | c b | b a | a d | c d | b c | a b | d a
        assertTrue(all.contains(new PuzzlePiece("1", "ab", "bc", "dc", "ad")));
        assertTrue(all.contains(new PuzzlePiece("1", "da", "ab", "cb", "dc")));
        assertTrue(all.contains(new PuzzlePiece("1", "cd", "da", "ba", "cb")));
        assertTrue(all.contains(new PuzzlePiece("1", "bc", "cd", "ad", "ba")));
        assertTrue(all.contains(new PuzzlePiece("1", "ba", "ad", "cd", "bc")));
        assertTrue(all.contains(new PuzzlePiece("1", "ad", "dc", "bc", "ab")));
        assertTrue(all.contains(new PuzzlePiece("1", "dc", "cb", "ab", "da")));
        assertTrue(all.contains(new PuzzlePiece("1", "cb", "ba", "da", "cd")));
    }

    @Test
    void remove() {
        // ab | e f
        // dc | h g
        PuzzlePiece piece1 = new PuzzlePiece("1", "ab", "bc", "dc", "ad");
        PuzzlePiece piece2 = new PuzzlePiece("2", "ef", "fg", "hg", "eh");
        Pieces pieces = new Pieces(new LinkedHashMap<>());
        pieces.addPiece(piece1);
        pieces.addPiece(piece2);
        assertEquals(16, pieces.getAllPieces().size());
        Pieces newPieces = pieces.remove("1");
        assertEquals(8, newPieces.getAllPieces().size());
        assertEquals(8, newPieces.getAllPieces().stream().filter(p -> p.getId().equals("2")).count());
        assertEquals(0, newPieces.getAllPieces().stream().filter(p -> p.getId().equals("1")).count());
    }
}