package esm.aoc.days.day20;

import esm.aoc.etl.solve.Solver;
import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.models.grid.Grid;
import esm.aoc.models.grid.MapBackedGrid;

import java.util.ArrayList;
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
        List<PartialSolvedPuzzle> candidates = new ArrayList<>();
        int gridSize = (int) Math.sqrt(pieces.size() / 8);
        for (PuzzlePiece piece : pieces) {
            Grid<PuzzlePiece> grid = new MapBackedGrid<>();
            grid.addItem(0, 0, piece);
            PartialSolvedPuzzle puzzle = new PartialSolvedPuzzle(gridSize, model.remove(piece.getId()), grid);
            candidates.add(puzzle);
        }
        PartialSolvedPuzzle answer = null;
        while (answer == null && !candidates.isEmpty()) {
            answer = expand(candidates);
        }
        System.out.println(answer);
        if (answer != null) {
            PuzzlePiece topLeft = answer.getPlaced().getItem(0, 0);
            PuzzlePiece topRight = answer.getPlaced().getItem(gridSize - 1, 0);
            PuzzlePiece bottomLeft = answer.getPlaced().getItem(0, gridSize - 1);
            PuzzlePiece bottomRight = answer.getPlaced().getItem(gridSize - 1, gridSize - 1);
            return Long.parseLong(topLeft.getId()) *
                   Long.parseLong(topRight.getId()) *
                   Long.parseLong(bottomLeft.getId()) *
                   Long.parseLong(bottomRight.getId());
        }
        return (long) 0;
    }

    public PartialSolvedPuzzle expand(List<PartialSolvedPuzzle> candidates) {
        PartialSolvedPuzzle puzzle = candidates.get(0);
        System.out.println(puzzle);
        if (puzzle.getSize() == 9) {
            return puzzle;
        }
        candidates.remove(puzzle);
        candidates.addAll(puzzle.getNext());
        candidates.sort((t1, t2) -> t2.getSize() - t1.getSize());
        return null;
    }

}
