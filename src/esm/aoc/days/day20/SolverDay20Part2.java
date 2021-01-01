package esm.aoc.days.day20;

import esm.aoc.etl.solve.Solver;
import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.models.grid.Grid;
import esm.aoc.models.grid.MapBackedGrid;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SolverDay20Part2 implements Solver<Pieces, Long> {

    public static void main(String[] args) {
        DaySolver<Pieces, Long> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(20),
                new PuzzleParser(),
                new SolverDay20Part2()
        );
        System.out.println(daySolver.solve());
    }

    @Override
    public Long solve(Pieces model) {
        PartialSolvedPuzzle puzzle = solvePuzzle(model);
        System.out.println(puzzle);
        Grid<String> grid = concatGrid(model, puzzle);
        System.out.println(grid.toString());
        return (long) 0;
    }

    private PartialSolvedPuzzle solvePuzzle(Pieces model) {
        Set<PuzzlePiece> pieces = model.getAllPieces();
        List<PartialSolvedPuzzle> candidates = new ArrayList<>();
        for (PuzzlePiece piece : pieces) {
            Grid<PuzzlePiece> grid = new MapBackedGrid<>();
            grid.addItem(0, 0, piece);
            PartialSolvedPuzzle puzzle = new PartialSolvedPuzzle(model.remove(piece.getId()), grid);
            candidates.add(puzzle);
        }
        PartialSolvedPuzzle answer = null;
        while (answer == null && !candidates.isEmpty()) {
            answer = expand(model.getTotalPieces(), candidates);
        }
        return answer;
    }

    private Grid<String> concatGrid(Pieces model, PartialSolvedPuzzle puzzle) {
        Grid<String> grid = new MapBackedGrid<>();
        int size = model.getPuzzleSize();
        int width = model.getPieceWidth();
        for (int y = 0; y < size * width; y++) {
            for (int x = 0; x < size * width; x++) {
                PuzzlePiece piece = puzzle.getPlaced().getItem(x / width, y / width);
                String item = piece.getGrid().getItem(x % width, y % width);
                grid.addItem(x, y, item);
            }
        }
        return grid;
    }

    public PartialSolvedPuzzle expand(int totalPieces, List<PartialSolvedPuzzle> candidates) {
        PartialSolvedPuzzle puzzle = candidates.get(0);
        if (puzzle.getSize() == totalPieces) {
            return puzzle;
        }
        candidates.remove(puzzle);
        candidates.addAll(puzzle.getNext());
        candidates.sort((t1, t2) -> t2.getSize() - t1.getSize());
        return null;
    }

}
