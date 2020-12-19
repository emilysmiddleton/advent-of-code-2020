package esm.aoc.days.day17;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;
import esm.aoc.models.grid.Grid3D;

public class SolverDay17Part1 implements Solver<ConwayCube, Integer> {
    public static void main(String[] args) {
        DaySolver<ConwayCube, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(17),
                new Grid3DParser(),
                new SolverDay17Part1()
        );
        System.out.println(daySolver.solve());
    }

    @Override
    public Integer solve(ConwayCube cube) {
        ConwayCube next = cube;
        for (int i = 0; i < 6; i++) {
            next = next.next();
        }
        return next.getActive().size();
    }
}
