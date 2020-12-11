package esm.aoc.days.day11;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;
import esm.aoc.etl.transform.GridTransformer;
import esm.aoc.etl.transform.StringSeparatedTransformer;

public class SolverDay11Part1 {

    public static void main(String[] args) {
        GridTransformer<String> xform = new GridTransformer<>(StringSeparatedTransformer.NO_SEPARATOR, s -> s);
        DaySolver<Layout, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(11),
                input -> new Layout(xform.buildModel(input)),
                new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<Layout, Integer> {
        @Override
        public Integer solve(Layout layout) {
            boolean changed = true;
            while (changed) {
                changed = layout.round();
            }
            return layout.countOccupied();
        }
    }

}
