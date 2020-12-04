package esm.aoc.days.day04;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

import java.util.List;

public class SolverDay4Part2 {

    public static void main(String[] args) {
        DaySolver<List<Passport>, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(4),
                new PassportParser(),
                new SolverPart2()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart2 implements Solver<List<Passport>, Integer> {
        @Override
        public Integer solve(List<Passport> grid) {
            return (int) grid.stream().filter(Passport::hasValidFields).count();
        }
    }

}
