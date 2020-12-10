package esm.aoc.days.day10;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;
import esm.aoc.etl.transform.IntegersTransformer;

public class SolverDay10Part2 {

    public static void main(String[] args) {
        DaySolver<Adapters, Long> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(10),
                input -> new Adapters(IntegersTransformer.TO_INTEGERS.buildModel(input)),
                new SolverPart2()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart2 implements Solver<Adapters, Long> {
        @Override
        public Long solve(Adapters adapters) {
            return adapters.countArrangements();
        }
    }

}
