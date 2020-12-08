package esm.aoc.days.day08;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

import java.util.List;

public class SolverDay8Part2 {

    public static void main(String[] args) {
        DaySolver<List<Program>, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(8),
                new MultiProgramParser(),
                new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<List<Program>, Integer> {
        @Override
        public Integer solve(List<Program> input) {
            for (Program program : input) {
                if (program.run()) {
                    return program.getAccumulator();
                }
            }
            return -1;
        }
    }

}
