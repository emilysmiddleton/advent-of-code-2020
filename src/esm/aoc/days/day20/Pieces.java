package esm.aoc.days.day20;

import java.util.*;

public class Pieces {

    private final Map<String, Set<PuzzlePiece>> map;
    private final int pieceWidth;
    private final int totalPieces;
    private final int puzzleSize;

    public Pieces(int pieceWidth, int totalPieces, int puzzleSize, Map<String, Set<PuzzlePiece>> map) {
        this.map = map;
        this.pieceWidth = pieceWidth;
        this.totalPieces = totalPieces;
        this.puzzleSize = puzzleSize;
    }

    public int getPieceWidth() {
        return pieceWidth;
    }

    public int getTotalPieces() {
        return totalPieces;
    }

    public int getPuzzleSize() {
        return puzzleSize;
    }

    public void addPiece(PuzzlePiece piece) {
        Set<PuzzlePiece> set = new LinkedHashSet<>();
        PuzzlePiece[] rotations = {
                piece,
                piece.rotate(),
                piece.rotate().rotate(),
                piece.rotate().rotate().rotate()
        };
        for (PuzzlePiece rotation : rotations) {
            set.add(rotation);
            set.add(rotation.flipVertical());
        }
        map.put(piece.getId(), set);
    }

    public Pieces remove(String id) {
        Map<String, Set<PuzzlePiece>> copy = new LinkedHashMap<>(map);
        copy.remove(id);
        return new Pieces(pieceWidth, totalPieces, puzzleSize, copy);
    }

    public Set<PuzzlePiece> getAllPieces() {
        Set<PuzzlePiece> set = new LinkedHashSet<>();
        map.entrySet().stream().forEach(e -> set.addAll(e.getValue()));
        return set;
    }

}
