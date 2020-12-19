package esm.aoc.days.day18;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

import java.math.BigInteger;

public class SolverDay18Part2 implements Solver<PuzzleInput, BigInteger> {

    public static void main(String[] args) {
        DaySolver<PuzzleInput, BigInteger> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(18),
                pi -> pi,
                new SolverDay18Part2()
        );
        System.out.println(daySolver.solve());
    }

    @Override
    public BigInteger solve(PuzzleInput model) {
        Maths maths = new Maths(true);
        return model.transform(maths::evaluate).stream()
                .reduce(BigInteger.ZERO, (a, b) -> a.add(b));
    }
}
