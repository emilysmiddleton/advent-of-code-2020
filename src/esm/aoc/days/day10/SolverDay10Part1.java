package esm.aoc.days.day10;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;
import esm.aoc.etl.transform.IntegersTransformer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolverDay10Part1 {

    public static void main(String[] args) {
        DaySolver<List<Integer>, Long> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(10),
                IntegersTransformer.TO_INTEGERS,
                new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<List<Integer>, Long> {
        @Override
        public Long solve(List<Integer> adapters) {
            adapters.sort(Integer::compareTo);
            List<Integer> diffs = IntStream.range(1, adapters.size())
                    .mapToObj(i -> adapters.get(i) - adapters.get(i - 1)).collect(Collectors.toList());
            return (diffs.stream().filter(i -> i == 1).count() + 1) *
                   (diffs.stream().filter(i -> i == 3).count() + 1);
        }
    }

}
