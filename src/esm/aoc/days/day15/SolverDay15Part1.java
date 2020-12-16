package esm.aoc.days.day15;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;
import esm.aoc.etl.transform.IntegersTransformer;
import esm.aoc.etl.transform.StringSeparatedTransformer;

import java.util.List;

public class SolverDay15Part1 {

    public static void main(String[] args) {
        DaySolver<List<Integer>, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(15),
                input -> IntegersTransformer.TO_INTEGERS.buildModel(
                    new PuzzleInput(StringSeparatedTransformer.COMMA_SEPARATED.buildModel(input).get(0))
                ),
                new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<List<Integer>, Integer> {
        @Override
        public Integer solve(List<Integer> model) {
            Game game = new Game(model);
            for (int i = game.getIndex(); i < 2020; i++) {
                System.out.println(i + " " + game.next());
            }
            return game.next();
        }
    }
}
