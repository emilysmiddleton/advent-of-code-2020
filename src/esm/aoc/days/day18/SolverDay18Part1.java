package esm.aoc.days.day18;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

public class SolverDay18Part1 implements Solver<PuzzleInput, Long> {

    public static void main(String[] args) {
        DaySolver<PuzzleInput, Long> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(18),
                pi -> pi,
                new SolverDay18Part1()
        );
        System.out.println(daySolver.solve());
    }

    @Override
    public Long solve(PuzzleInput model) {
        Maths maths = new Maths();
        return model.transform(maths::evaluate).stream().mapToLong(i -> i).sum();
    }
}
