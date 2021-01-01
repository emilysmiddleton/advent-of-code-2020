package esm.aoc.days.day20;

import esm.aoc.models.grid.Grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PuzzlePiece {

    private final String id;
    private final int rotations;
    private final boolean flipped;
    private final int width;
    private final Grid<String> grid;
    private final String top;
    private final String right;
    private final String bottom;
    private final String left;
    private final List<PuzzlePiece> fitsLeft = new ArrayList<>();
    private final List<PuzzlePiece> fitsTop = new ArrayList<>();
    private final List<PuzzlePiece> fitsRight = new ArrayList<>();
    private final List<PuzzlePiece> fitsBottom = new ArrayList<>();

    public PuzzlePiece(String id, int width, Grid<String> grid) {
        this(id, 0, false, width, grid);
    }

    public PuzzlePiece(String id, int rotations, boolean flipped, int width, Grid<String> grid) {
        this.id = id;
        this.rotations = rotations;
        this.flipped = flipped;
        this.top = getTop(width, grid);
        this.right = getRight(width, grid);
        this.bottom = getBottom(width, grid);
        this.left = getLeft(width, grid);
        this.grid = grid;
        this.width = width;
    }

    public int buildNetwork(Pieces pieces) {
        for (PuzzlePiece piece : pieces.getAllPieces()) {
            if (!piece.getId().equals(id)) {
                if (right.equals(piece.getLeft())) {
                    fitsRight.add(piece);
                }
                if (left.equals(piece.getRight())) {
                    fitsLeft.add(piece);
                }
                if (top.equals(piece.getBottom())) {
                    fitsTop.add(piece);
                }
                if (bottom.equals(piece.getTop())) {
                    fitsBottom.add(piece);
                }
            }
        }
        return Math.min(1, fitsTop.size()) +
                Math.min(1, fitsLeft.size()) +
                Math.min(1, fitsRight.size()) +
                Math.min(1, fitsBottom.size());
    }

    public String getId() {
        return id;
    }

    public String getBottom() {
        return bottom;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public String getTop() {
        return top;
    }

    public PuzzlePiece rotate() {
        return new PuzzlePiece(
            id,
            rotations + 1,
            flipped,
            width,
            grid.rotate(width)
        );
    }

    /**
     * Flip along the horizontal axis.
     * top/bottom change places, left/right are reversed
     */
    public PuzzlePiece flipHorizontal() {
        return new PuzzlePiece(
                id,
                rotations,
                !flipped,
                width,
                grid.flipHorizontal(width)
        );
    }

    /**
     * Flip along the vertical axis.
     * left/right change places, top/bottom are reversed
     */
    public PuzzlePiece flipVertical() {
        return new PuzzlePiece(
                id,
                rotations,
                !flipped,
                width,
                grid.flipVertical(width)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PuzzlePiece that = (PuzzlePiece) o;
        return Objects.equals(id, that.id) && Objects.equals(top, that.top) && Objects.equals(right, that.right) && Objects.equals(bottom, that.bottom) && Objects.equals(left, that.left);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, top, right, bottom, left);
    }

    @Override
    public String toString() {
        return id + "\n" + grid.toString();
    }

    public Grid<String> getGrid() {
        return grid;
    }

    private String getTop(int width, Grid<String> grid) {
        StringBuilder builder = new StringBuilder();
        for (int x = 0; x < width; x++) {
            builder.append(grid.getItem(x, 0));
        }
        return builder.toString();
    }

    private String getRight(int width, Grid<String> grid) {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < width; y++) {
            builder.append(grid.getItem(width - 1, y));
        }
        return builder.toString();
    }

    private String getBottom(int width, Grid<String> grid) {
        StringBuilder builder = new StringBuilder();
        for (int x = 0; x < width; x++) {
            builder.append(grid.getItem(x, width - 1));
        }
        return builder.toString();
    }

    private String getLeft(int width, Grid<String> grid) {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < width; y++) {
            builder.append(grid.getItem(0, y));
        }
        return builder.toString();
    }

    public String getConfig() {
        return id + rotations + (flipped ? 't' : 'f');
    }
}
