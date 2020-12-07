package esm.aoc.days.day07;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

public class SolverDay7Part1 {

    public static void main(String[] args) {
        DaySolver<Rules, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(7),
                new RulesParser(),
                new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<Rules, Integer> {
        @Override
        public Integer solve(Rules rules) {
            return 0;
        }
    }

}
