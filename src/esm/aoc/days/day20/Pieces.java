package esm.aoc.days.day20;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pieces {

    private final Map<Integer, PuzzlePiece> pieces = new LinkedHashMap<>();

    public void addPiece(PuzzlePiece piece) {
        pieces.put(piece.getId(), piece);
    }

    public Map<Integer, PuzzlePiece> getPieces() {
        return pieces;
    }
}
