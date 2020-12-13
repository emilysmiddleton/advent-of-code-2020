package esm.aoc.days.day12;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.transform.Transformer;
import esm.aoc.models.grid.Direction2D;

import java.util.List;
import java.util.function.Function;

public class InstructionParser implements Transformer<List<Function<ShipState, ShipState>>> {

    @Override
    public List<Function<ShipState, ShipState>> buildModel(PuzzleInput input) {
        return input.transform(this::parse);
    }

    public Function<ShipState, ShipState> parse(String instruction) {
        String command = instruction.substring(0, 1);
        int value = Integer.parseInt(instruction.substring(1));
        switch (command) {
            case "N": return move(Direction2D.UP, value);
            case "S": return move(Direction2D.DOWN, value);
            case "E": return move(Direction2D.RIGHT, value);
            case "W": return move(Direction2D.LEFT, value);
            case "F": return state -> new ShipState(state.getFacing(), state.getPosition().move(state.getFacing(), value));
            case "L": return state -> new ShipState(state.getFacing().anticlockwise(value / 45), state.getPosition());
            case "R": return state -> new ShipState(state.getFacing().clockwise(value / 45), state.getPosition());
            default: throw new IllegalArgumentException(command);
        }
    }

    private Function<ShipState, ShipState> move(Direction2D direction, int value) {
        return state -> new ShipState(state.getFacing(), state.getPosition().move(direction, value));
    }

}
