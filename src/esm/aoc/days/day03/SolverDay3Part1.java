package esm.aoc.days.day03;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

public class SolverDay3Part1 {

    public static void main(String[] args) {
        DaySolver<TreeGrid, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(3),
                TreeGrid.TRANSFORM,
                new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<TreeGrid, Integer> {
        @Override
        public Integer solve(TreeGrid grid) {
            return grid.countTrees(3, 1);
        }
    }

}
