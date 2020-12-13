package esm.aoc.models.grid;

import java.util.Objects;

public class Coordinate2D {
    private final int x;
    private final int y;

    public Coordinate2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinate2D move(Direction2D direction, int spaces) {
        switch (direction) {
            case UP: return new Coordinate2D(x, y - spaces);
            case DOWN: return new Coordinate2D(x, y + spaces);
            case LEFT: return new Coordinate2D(x - spaces, y);
            case RIGHT: return new Coordinate2D(x + spaces, y);
            case UP_LEFT: return new Coordinate2D(x - spaces, y - spaces);
            case UP_RIGHT: return new Coordinate2D(x + spaces, y - spaces);
            case DOWN_LEFT: return new Coordinate2D(x - spaces, y + spaces);
            case DOWN_RIGHT: return new Coordinate2D(x + spaces, y + spaces);
            default: throw new IllegalArgumentException("Unrecognised direction " + direction);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate2D that = (Coordinate2D) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}
