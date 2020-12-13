package esm.aoc.days.day12;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;
import esm.aoc.models.grid.Coordinate2D;
import esm.aoc.models.grid.Direction2D;

import java.util.List;
import java.util.function.Function;

public class SolverDay12Part1 {

    public static void main(String[] args) {
        DaySolver<List<Function<ShipState, ShipState>>, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(12),
                new InstructionParser(),
                new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<List<Function<ShipState, ShipState>>, Integer> {
        @Override
        public Integer solve(List<Function<ShipState, ShipState>> instructions) {
            ShipState state = new ShipState(Direction2D.RIGHT, new Coordinate2D(0, 0));
            for (Function<ShipState, ShipState> instruction : instructions) {
                state = instruction.apply(state);
                System.out.println(state.getPosition());
            }
            return Math.abs(state.getPosition().getX()) + Math.abs(state.getPosition().getY());
        }
    }

}
