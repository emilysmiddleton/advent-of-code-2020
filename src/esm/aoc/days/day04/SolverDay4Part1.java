package esm.aoc.days.day04;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

import java.util.List;

public class SolverDay4Part1 {

    public static void main(String[] args) {
        DaySolver<List<Passport>, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(4),
                new PassportParser(),
                new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<List<Passport>, Integer> {
        @Override
        public Integer solve(List<Passport> grid) {
            return (int) grid.stream().filter(Passport::hasPresentFields).count();
        }
    }

}
