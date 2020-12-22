package esm.aoc.days.day20;

import esm.aoc.etl.solve.Solver;
import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SolverDay20Part1 implements Solver<Pieces, Integer> {

    public static void main(String[] args) {
        DaySolver<Pieces, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(20),
                new PuzzleParser(),
                new SolverDay20Part1()
        );
        System.out.println(daySolver.solve());
    }

    @Override
    public Integer solve(Pieces model) {
        System.out.println(model.getPieces());
        return 0;
    }
}
