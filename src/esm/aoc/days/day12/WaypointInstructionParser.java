package esm.aoc.days.day12;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.transform.Transformer;
import esm.aoc.models.grid.Coordinate2D;
import esm.aoc.models.grid.Direction2D;

import java.util.List;
import java.util.function.Function;

public class WaypointInstructionParser implements Transformer<List<Function<WaypointState, WaypointState>>> {

    @Override
    public List<Function<WaypointState, WaypointState>> buildModel(PuzzleInput input) {
        return input.transform(this::parse);
    }

    public Function<WaypointState, WaypointState> parse(String instruction) {
        String command = instruction.substring(0, 1);
        int value = Integer.parseInt(instruction.substring(1));
        switch (command) {
            case "N":
                return move(Direction2D.UP, value);
            case "S":
                return move(Direction2D.DOWN, value);
            case "E":
                return move(Direction2D.RIGHT, value);
            case "W":
                return move(Direction2D.LEFT, value);
            case "F":
                return forward(value);
            case "L":
                return antiClockwise(value);
            case "R":
                return clockwise(value);
            default:
                throw new IllegalArgumentException(command);
        }
    }

    private Function<WaypointState, WaypointState> move(Direction2D direction, int value) {
        return state -> new WaypointState(state.getWaypoint().move(direction, value), state.getShip());
    }

    private Function <WaypointState, WaypointState> forward(int value) {
        return state -> {
            int right = state.getWaypoint().getX() * value;
            int down = state.getWaypoint().getY() * value;
            Coordinate2D ship = state.getShip().move(Direction2D.RIGHT, right).move(Direction2D.DOWN, down);
            return new WaypointState(state.getWaypoint(), ship);
        };
    }

    private Function <WaypointState, WaypointState> clockwise(int value) {
        return state -> {
            WaypointState newState = state;
            for (int i = 0; i < value / 90; i++) {
                int x = newState.getWaypoint().getX() ;
                int y = newState.getWaypoint().getY();
                newState = new WaypointState(new Coordinate2D(-y, x), state.getShip());
            }
            return newState;
        };
    }

    private Function <WaypointState, WaypointState> antiClockwise(int value) {
        return state -> {
            WaypointState newState = state;
            for (int i = 0; i < value / 90; i++) {
                int x = newState.getWaypoint().getX();
                int y = newState.getWaypoint().getY();
                newState = new WaypointState(new Coordinate2D(y, -x), state.getShip());
            }
            return newState;
        };
    }

}
