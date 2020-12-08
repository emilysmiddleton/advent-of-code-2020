package esm.aoc.days.day08;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

public class SolverDay8Part1 {

    public static void main(String[] args) {
        DaySolver<Program, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(8),
                new ProgramParser(),
                new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<Program, Integer> {
        @Override
        public Integer solve(Program program) {
            program.run();
            return program.getAccumulator();
        }
    }

}
