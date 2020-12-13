package esm.aoc.days.day12;

import esm.aoc.models.grid.Coordinate2D;
import esm.aoc.models.grid.Direction2D;

public class ShipState {

    private final Direction2D facing;
    private final Coordinate2D position;

    public ShipState(Direction2D facing, Coordinate2D position) {
        this.facing = facing;
        this.position = position;
    }

    public Coordinate2D getPosition() {
        return position;
    }

    public Direction2D getFacing() {
        return facing;
    }
}
