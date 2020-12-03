package esm.aoc.days.day03;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

public class SolverDay3Part2 {

    public static void main(String[] args) {
        DaySolver<TreeGrid, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(3),
                TreeGrid.TRANSFORM,
                new SolverDay3Part2.SolverPart2()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart2 implements Solver<TreeGrid, Integer> {
        @Override
        public Integer solve(TreeGrid grid) {
            return  grid.countTrees(1, 1) *
                    grid.countTrees(3, 1) *
                    grid.countTrees(5, 1) *
                    grid.countTrees(7, 1) *
                    grid.countTrees(1, 2);
        }
    }


}
