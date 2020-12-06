package esm.aoc.days.day06;

import esm.aoc.days.day05.Seat;
import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

import java.util.List;

public class SolverDay6Part1 {

    public static void main(String[] args) {
        DaySolver<List<CustomQuestions>, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(6),
                new CustomQuestionParser(),
                new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<List<CustomQuestions>, Integer> {
        @Override
        public Integer solve(List<CustomQuestions> seats) {
            return seats.stream().mapToInt(CustomQuestions::size).sum();
        }
    }

}
