package esm.aoc.days.day15;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;
import esm.aoc.etl.transform.IntegersTransformer;
import esm.aoc.etl.transform.StringSeparatedTransformer;

import java.util.List;

public class SolverDay15Part2 {

    public static void main(String[] args) {
        DaySolver<List<Integer>, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(15),
                input -> IntegersTransformer.TO_INTEGERS.buildModel(
                        new PuzzleInput(StringSeparatedTransformer.COMMA_SEPARATED.buildModel(input).get(0))
                ),
                new SolverPart2()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart2 implements Solver<List<Integer>, Integer> {
        @Override
        public Integer solve(List<Integer> model) {
            Game game = new Game(model);
            for (int i = game.getIndex(); i < 30000000; i++) {
                game.next();
            }
            return game.next();
        }
    }
}
