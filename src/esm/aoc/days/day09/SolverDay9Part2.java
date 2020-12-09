package esm.aoc.days.day09;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;
import esm.aoc.etl.transform.LongsTransformer;

import java.util.List;

public class SolverDay9Part2 {

    public static void main(String[] args) {
        DaySolver<XMAS, Long> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(9),
                input -> new XMAS(LongsTransformer.TO_LONGS.buildModel(input)),
                new SolverPart2()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart2 implements Solver<XMAS, Long> {
        @Override
        public Long solve(XMAS xmas) {
            List<Long> sum = xmas.getContiguousSum();
            long min = sum.stream().min(Long::compareTo).get();
            long max = sum.stream().max(Long::compareTo).get();
            return min + max;
        }
    }

}
