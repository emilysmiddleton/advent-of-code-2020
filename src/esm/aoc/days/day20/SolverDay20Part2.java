package esm.aoc.days.day20;

import esm.aoc.etl.solve.Solver;
import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.models.grid.Coordinate2D;
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
        System.out.println("Answer");
        System.out.println(puzzle);
        Grid<String> grid = concatGrid(model, puzzle);
        int monsters = countMonsters(model, grid);
        long hashes = grid.getCoordinates().stream()
                .map(grid::getItem)
                .filter(s -> "#".equals(s))
                .count();
        return hashes - (monsters * 15);
    }

    private List<Grid<String>> variations(Grid<String> grid, int size) {
        Grid<String> flipped = grid.flipVertical(size);
        return List.of(
            grid,
            grid.rotate(size),
            grid.rotate(size).rotate(size),
            grid.rotate(size).rotate(size).rotate(size),
                flipped,
                flipped.rotate(size),
                flipped.rotate(size).rotate(size),
                flipped.rotate(size).rotate(size).rotate(size)
        );

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
        int width = model.getPieceWidth();
        for (int puzzleY = 0; puzzleY < model.getPuzzleSize(); puzzleY++) {
            for (int puzzleX = 0; puzzleX < model.getPuzzleSize(); puzzleX++) {
                PuzzlePiece piece = puzzle.getPlaced().getItem(puzzleX, puzzleY);
                for (int pieceY = 1; pieceY < width - 1; pieceY++) {
                    for (int pieceX = 1; pieceX < width - 1; pieceX++) {
                        int x = (puzzleX * (width - 2)) + pieceX - 1;
                        int y = (puzzleY * (width - 2)) + pieceY - 1;
                        grid.addItem(x, y, piece.getGrid().getItem(pieceX, pieceY));
                    }
                }
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

    private int countMonsters(Pieces model, Grid<String> grid) {
        int gridSize = (model.getPieceWidth() - 2) * model.getPuzzleSize();
        for (Grid<String> variation : variations(grid, gridSize)) {
            int count = lookForMonsters(model, variation);
            if (count > 0) {
                return count;
            }
        }
        return 0;
    }

    private int lookForMonsters(Pieces model, Grid<String> grid) {
        int gridSize = model.getPieceWidth() * model.getPuzzleSize();
        Coordinate2D[] monster = {
                new Coordinate2D(0, 1),
                new Coordinate2D(1, 2),
                new Coordinate2D(4, 2),
                new Coordinate2D(5, 1),
                new Coordinate2D(6, 1),
                new Coordinate2D(7, 2),
                new Coordinate2D(10, 2),
                new Coordinate2D(11, 1),
                new Coordinate2D(12, 1),
                new Coordinate2D(13, 2),
                new Coordinate2D(16, 2),
                new Coordinate2D(17, 1),
                new Coordinate2D(18, 1),
                new Coordinate2D(18, 0),
                new Coordinate2D(19, 1)
        };
        int matches = 0;

        for (int y = 0; y < gridSize; y++) {
            for (int x = 0; x < gridSize; x++) {
                boolean match = checkForMonster(x, y, grid, monster);
                if (match) {
                    matches++;
                }
            }
        }
        return matches;
    }

    private boolean checkForMonster(int x, int y,  Grid<String> grid, Coordinate2D[] monster) {
        for (Coordinate2D coordinate : monster) {
            if (!"#".equals(grid.getItem(x + coordinate.getX(), y + coordinate.getY()))) {
                return false;
            }
        }
        return true;
    }

}
