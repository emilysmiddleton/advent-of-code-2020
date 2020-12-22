package esm.aoc.days.day20;

import esm.aoc.models.grid.Direction2D;
import esm.aoc.models.grid.Grid;

public class GridPuzzlePiece implements PuzzlePiece {

    private int id;
    private final int size;
    private final Grid<String> grid;
    private int rotation = 0;

    public GridPuzzlePiece(int id, int size, Grid<String> grid) {
        this.grid = grid;
        this.size = size;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean fits(Direction2D direction, PuzzlePiece piece) {
        return getEdge(direction).matches(piece.getEdge(direction.opposite()));
    }

    @Override
    public String getEdge(Direction2D direction) {
        // a b
        // c d
        if (rotation == 0) {
            switch (direction) {
                case UP:
                    // a b
                    return topEdge(false);
                case RIGHT:
                    // b d
                    return rightEdge(false);
                case DOWN:
                    // c d
                    return bottomEdge(false);
                default:
                    // a c
                    return leftEdge(false);
            }
        }
        // a b   c a
        // c d   d b
        if (rotation == 90) {
            switch (direction) {
                case UP:
                    // c a
                    return leftEdge(true);
                case RIGHT:
                    // a b
                    return topEdge(false);
                case DOWN:
                    // d b
                    return rightEdge(true);
                default:
                    // c d
                    return bottomEdge(false);
            }
        }
        // a b  d c
        // c d  b a
        if (rotation == 180) {
            switch (direction) {
                case UP:
                    // d c
                    return bottomEdge(true);
                case RIGHT:
                    // c a
                    return leftEdge(true);
                case DOWN:
                    // b a
                    return topEdge(true);
                default:
                    // d b
                    return rightEdge(true);
            }
        }
        // a b  b d
        // c d  a c
        if (rotation == 270) {
            switch (direction) {
                case UP:
                    // b d
                    return rightEdge(false);
                case RIGHT:
                    // d c
                    return bottomEdge(true);
                case DOWN:
                    // a c
                    return leftEdge(false);
                default:
                    // b a
                    return topEdge(true);
            }
        }
        throw new IllegalArgumentException();
    }

    private String topEdge(boolean reverse) {
        StringBuilder builder = new StringBuilder();
        for (int x = 0; x < size; x++) {
            builder.append(grid.getItem(x, 0));
        }
        return reverse ? builder.reverse().toString() : builder.toString();
    }

    private String bottomEdge(boolean reverse) {
        StringBuilder builder = new StringBuilder();
        for (int x = 0; x < size; x++) {
            builder.append(grid.getItem(x, size - 1));
        }
        return reverse ? builder.reverse().toString() : builder.toString();
    }

    private String leftEdge(boolean reverse) {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < size; y++) {
            builder.append(grid.getItem(0, y));
        }
        return reverse ? builder.reverse().toString() : builder.toString();
    }

    private String rightEdge(boolean reverse) {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < size; y++) {
            builder.append(grid.getItem(size - 1, y));
        }
        return reverse ? builder.reverse().toString() : builder.toString();
    }

    @Override
    public String toString() {
        return grid.toString();
    }
}
