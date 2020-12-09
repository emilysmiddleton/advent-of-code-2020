package esm.aoc.days.day09;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;
import esm.aoc.etl.transform.LongsTransformer;

public class SolverDay9Part1 {

    public static void main(String[] args) {
        DaySolver<XMAS, Long> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(9),
                input -> new XMAS(LongsTransformer.TO_LONGS.buildModel(input)),
                new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<XMAS, Long> {
        @Override
        public Long solve(XMAS xmas) {
            return xmas.getFirstInvalid();
        }
    }

}
