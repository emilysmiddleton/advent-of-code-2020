package esm.aoc.days.day12;

import esm.aoc.models.grid.Coordinate2D;

public class WaypointState {
    private final Coordinate2D waypoint;
    private final Coordinate2D ship;

    public WaypointState(Coordinate2D waypoint, Coordinate2D ship) {
        this.waypoint = waypoint;
        this.ship = ship;
    }

    public Coordinate2D getWaypoint() {
        return waypoint;
    }

    public Coordinate2D getShip() {
        return ship;
    }
}
