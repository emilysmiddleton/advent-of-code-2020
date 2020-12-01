package esm.aoc.days.day01;

import esm.aoc.days.day00.Module;
import esm.aoc.days.day00.ModuleParser;
import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;
import esm.aoc.etl.transform.IntegersTransformer;

import java.util.List;

public class SolverDay1Part1 {

    public static void main(String[] args) {
        DaySolver<List<Integer>, Integer> daySolver = new DaySolver<>(
            new PuzzleInputExtractor(1),
            new IntegersTransformer(),
            new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<List<Integer>, Integer> {
        @Override
        public Integer solve(List<Integer> inputs) {
            for (int i = 0; i < inputs.size(); i++) {
                for (int j = i + 1; j < inputs.size(); j++) {
                    int sum = inputs.get(i) + inputs.get(j);
                    if (sum == 2020) {
                        return inputs.get(i) * inputs.get(j);
                    }
                }
            }
            return -1;
        }
    }

}
