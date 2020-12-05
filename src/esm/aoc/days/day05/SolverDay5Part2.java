package esm.aoc.days.day05;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SolverDay5Part2 {

    public static void main(String[] args) {
        DaySolver<List<Seat>, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(5),
                input -> input.transform(Seat::new),
                new SolverPart2()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart2 implements Solver<List<Seat>, Integer> {
        @Override
        public Integer solve(List<Seat> seats) {
            Set<Integer> ids = seats.stream().map(Seat::getID).collect(Collectors.toSet());
            for (int row = 1;  row < 128; row++) {
                for (int column = 0; column < 8; column++) {
                    int id = row * 8 + column;
                    if (!ids.contains(id) && ids.contains(id - 1) && ids.contains(id + 1)) {
                        return id;
                    }
                }
            }
            return -1;
        }
    }

}
