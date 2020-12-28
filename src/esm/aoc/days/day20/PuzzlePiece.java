package esm.aoc.days.day20;

import java.util.Objects;

public class PuzzlePiece {

    private final String id;
    private final String top;
    private final String right;
    private final String bottom;
    private final String left;

    public PuzzlePiece(String id, String top, String right, String bottom, String left) {
        this.id = id;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
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
            reverse(left),
            top,
            reverse(right),
            bottom
        );
    }

    /**
     * Flip along the horizontal axis.
     * top/bottom change places, left/right are reversed
     */
    public PuzzlePiece flipHorizontal() {
        return new PuzzlePiece(
                id,
                bottom,
                reverse(right),
                top,
                reverse(left)
        );
    }

    /**
     * Flip along the vertical axis.
     * left/right change places, top/bottom are reversed
     */
    public PuzzlePiece flipVertical() {
        return new PuzzlePiece(
                id,
                reverse(top),
                left,
                reverse(bottom),
                right
        );
    }

    private String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
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
}
