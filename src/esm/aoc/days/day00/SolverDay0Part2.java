package esm.aoc.days.day00;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

import java.util.List;

public class SolverDay0Part2 {

    public static void main(String[] args) {
        DaySolver<List<Module>, Integer> daySolver = new DaySolver<>(
            new PuzzleInputExtractor(0),
            new ModuleParser(),
            new SolverPart2()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart2 implements Solver<List<Module>, Integer> {
        @Override
        public Integer solve(List<Module> modules) {
            return modules.stream()
                    .mapToInt(Module::getFuelRequirementsPart2)
                    .sum();
        }
    }

}
