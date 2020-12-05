package esm.aoc.days.day05;

import esm.aoc.days.day04.Passport;
import esm.aoc.days.day04.PassportParser;
import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;
import esm.aoc.etl.transform.Transformer;

import java.util.List;

public class SolverDay5Part1 {

    public static void main(String[] args) {
        DaySolver<List<Seat>, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(5),
                input -> input.transform(Seat::new),
                new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<List<Seat>, Integer> {
        @Override
        public Integer solve(List<Seat> seats) {
            return seats.stream().map(Seat::getID).max(Integer::compareTo).get();
        }
    }

}
