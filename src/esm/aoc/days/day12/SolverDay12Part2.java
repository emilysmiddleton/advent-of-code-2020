package esm.aoc.days.day12;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;
import esm.aoc.models.grid.Coordinate2D;

import java.util.List;
import java.util.function.Function;

public class SolverDay12Part2 {

    public static void main(String[] args) {
        DaySolver<List<Function<WaypointState, WaypointState>>, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(12),
                new WaypointInstructionParser(),
                new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<List<Function<WaypointState, WaypointState>>, Integer> {
        @Override
        public Integer solve(List<Function<WaypointState, WaypointState>> instructions) {
            WaypointState state = new WaypointState(new Coordinate2D(10, -1), new Coordinate2D(0, 0));
            for (Function<WaypointState, WaypointState> instruction : instructions) {
                state = instruction.apply(state);
                System.out.println(state.getWaypoint() + " " + state.getShip());
            }
            return Math.abs(state.getShip().getX()) + Math.abs(state.getShip().getY());
        }
    }
}
