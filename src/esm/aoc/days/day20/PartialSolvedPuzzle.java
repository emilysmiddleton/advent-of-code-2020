package esm.aoc.days.day20;

import esm.aoc.models.grid.Coordinate2D;
import esm.aoc.models.grid.Direction2D;
import esm.aoc.models.grid.Grid;
import esm.aoc.models.grid.MapBackedGrid;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PartialSolvedPuzzle {
    private final int size;
    private final Pieces pieces;
    private final Grid<PuzzlePiece> placed = new MapBackedGrid<>();

    public PartialSolvedPuzzle(int size, Pieces pieces, Grid<PuzzlePiece> start) {
        start.getCoordinates().forEach(c -> placed.addItem(c, start.getItem(c)));
        this.pieces = pieces;
        this.size = size;
    }

    public Grid<PuzzlePiece> getPlaced() {
        return placed;
    }

    public Coordinate2D getNextCoordinate() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (placed.getItem(x, y) == null) {
                    return new Coordinate2D(x, y);
                }
            }
        }
        return null;
    }

    private List<PuzzlePiece> matchingPieces() {
        Coordinate2D next = getNextCoordinate();
        Set<PuzzlePiece> allPieces = pieces.getAllPieces();
        PuzzlePiece left = placed.getItem(next.move(Direction2D.LEFT, 1));
        PuzzlePiece up = placed.getItem(next.move(Direction2D.UP, 1));
        return allPieces.stream()
                .filter(piece -> left == null || left.getRight().equals(piece.getLeft()))
                .filter(piece -> up == null || up.getBottom().equals(piece.getTop()))
                .collect(Collectors.toList());
    }

    public List<PartialSolvedPuzzle> getNext() {
        List<PartialSolvedPuzzle> next = new ArrayList<>();
        System.out.println(matchingPieces().stream().map(PuzzlePiece::getId).collect(Collectors.joining(" ")));
        for (PuzzlePiece nextPiece: matchingPieces()) {
            Pieces nextPieces = pieces.remove(nextPiece.getId());
            Grid<PuzzlePiece> nextGrid = placePiece(nextPiece);
            PartialSolvedPuzzle nextPuzzle = new PartialSolvedPuzzle(size, nextPieces, nextGrid);
            next.add(nextPuzzle);
        }
        return next;
    }

    public Grid<PuzzlePiece> placePiece(PuzzlePiece nextPiece) {
        Grid<PuzzlePiece> newGrid = new MapBackedGrid<>();
        placed.getCoordinates().forEach(c -> newGrid.addItem(c, placed.getItem(c)));
        newGrid.addItem(getNextCoordinate(), nextPiece);
        return newGrid;
    }
    public int getSize() {
        return placed.getCoordinates().size();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                PuzzlePiece piece = placed.getItem(x, y);
                builder.append(piece == null ? "xxxx " : piece.getId() + " ");
            }
            builder.append("\n");
        }
        builder.append("\n");
        return builder.toString();
    }

}
