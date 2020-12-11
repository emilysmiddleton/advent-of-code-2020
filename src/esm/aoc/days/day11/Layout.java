package esm.aoc.days.day11;

import esm.aoc.models.grid.Coordinate2D;
import esm.aoc.models.grid.Direction2D;
import esm.aoc.models.grid.Grid;
import esm.aoc.models.grid.MapBackedGrid;

import java.util.Arrays;

public class Layout {

    private Grid<String> grid;

    public Layout(Grid<String> grid) {
        this.grid = grid;
    }

    public boolean round() {
         Grid<String> newGrid = new MapBackedGrid<>();
         grid.getCoordinates().stream()
                 .forEach(c -> newGrid.addItem(c, getNextValue(c)));
         boolean changed = !newGrid.equals(grid);
         grid = newGrid;
         return changed;
    }

    public int countOccupied() {
        return (int) grid.getCoordinates().stream().filter(this::isOccupied).count();
    }

    private boolean isOccupied(Coordinate2D coordinate) {
        return "#".equals(grid.getItem(coordinate));
    }

    private String getNextValue(Coordinate2D coordinate) {
        String current = grid.getItem(coordinate);
        int occupied = countAdjacentOccupied(coordinate);
        return switch (current) {
            // If a seat is empty (L) and there are no occupied seats adjacent to it, the seat becomes occupied.
            case "L" -> occupied == 0 ? "#" : "L";
            // If a seat is occupied (#) and four or more seats adjacent to it are also occupied, the seat becomes empty.
            case "#" -> occupied >= 4 ? "L" : "#";
            default -> ".";
        };
    }

    private int countAdjacentOccupied(Coordinate2D coordinate2D) {
        return (int) Arrays.stream(Direction2D.values())
                .map(d -> coordinate2D.move(d, 1))
                .filter(this::isOccupied)
                .count();
    }

}
