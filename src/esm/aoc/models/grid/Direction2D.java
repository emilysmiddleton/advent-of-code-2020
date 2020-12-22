package esm.aoc.models.grid;

public enum Direction2D {
    UP,
    UP_RIGHT,
    RIGHT,
    DOWN_RIGHT,
    DOWN,
    DOWN_LEFT,
    LEFT,
    UP_LEFT;

    public Direction2D clockwise(int number) {
        return Direction2D.values()[(ordinal() + number) % 8];
    }
    public Direction2D anticlockwise(int number) {
        return Direction2D.values()[(ordinal() - number + 8) % 8];
    }
    public Direction2D opposite() { return clockwise(4); }
}
