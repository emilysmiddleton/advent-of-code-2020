package esm.aoc.days.day20;

import esm.aoc.models.grid.Direction2D;

public interface PuzzlePiece {

    int getId();
    boolean fits(Direction2D direction, PuzzlePiece piece);
    String getEdge(Direction2D direction);
}
