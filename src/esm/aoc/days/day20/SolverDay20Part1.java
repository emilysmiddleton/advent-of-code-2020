package esm.aoc.days.day20;

import esm.aoc.etl.solve.Solver;
import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.models.grid.Grid;
import esm.aoc.models.grid.MapBackedGrid;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SolverDay20Part1 implements Solver<Pieces, Long> {

    public static void main(String[] args) {
        DaySolver<Pieces, Long> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(20),
                new PuzzleParser(),
                new SolverDay20Part1()
        );
        System.out.println(daySolver.solve());
    }

    @Override
    public Long solve(Pieces model) {
        Set<PuzzlePiece> pieces = model.getAllPieces();
        Set<Long> corners = new LinkedHashSet<>();
        for (PuzzlePiece piece : pieces) {
            int sum = piece.buildNetwork(model);
            if (sum == 2) {
                corners.add(Long.parseLong(piece.getId()));
            }
        }
        return corners.stream().reduce((long) 1, (a, b) -> a * b);
    }

}
