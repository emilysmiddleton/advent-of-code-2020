package esm.aoc.days.day20;

import java.util.*;

public class Pieces {

    private final Map<String, Set<PuzzlePiece>> map;

    public Pieces(Map<String, Set<PuzzlePiece>> map) {
        this.map = map;
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
            set.add(rotation.flipHorizontal());
            set.add(rotation.flipVertical());
        }
        System.out.println(set);
        map.put(piece.getId(), set);
    }

    public Pieces remove(String id) {
        Map<String, Set<PuzzlePiece>> copy = new LinkedHashMap<>(map);
        copy.remove(id);
        return new Pieces(copy);
    }

    public Set<PuzzlePiece> getAllPieces() {
        Set<PuzzlePiece> set = new LinkedHashSet<>();
        map.entrySet().stream().forEach(e -> set.addAll(e.getValue()));
        return set;
    }

}
