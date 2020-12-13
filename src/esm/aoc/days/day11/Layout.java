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

    public boolean round(boolean adjacent) {
         Grid<String> newGrid = new MapBackedGrid<>();
         grid.getCoordinates()
                 .forEach(c -> newGrid.addItem(c, getNextValue(c, adjacent)));
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

    private String getNextValue(Coordinate2D coordinate, boolean adjacent) {
        String current = grid.getItem(coordinate);
        int occupied = adjacent ? countAdjacentOccupied(coordinate): countNextSeatOccupied(coordinate);
        int limit = adjacent ? 4 : 5;
        switch (current) {
            // If a seat is empty (L) and there are no occupied seats adjacent to it, the seat becomes occupied.
            case "L": return occupied == 0 ? "#" : "L";
            // If a seat is occupied (#) and four or more seats adjacent to it are also occupied, the seat becomes empty.
            case "#": return occupied >= limit ? "L" : "#";
            default: return ".";
        }
    }

    private Coordinate2D getNextSeat(Coordinate2D coordinate, Direction2D direction) {
        Coordinate2D location = coordinate.move(direction, 1);
        while (".".equals(grid.getItem(location))) {
            location = location.move(direction, 1);
        }
        return location;
    }
    private int countAdjacentOccupied(Coordinate2D coordinate2D) {
        return (int) Arrays.stream(Direction2D.values())
                .map(d -> coordinate2D.move(d, 1))
                .filter(this::isOccupied)
                .count();
    }

    private int countNextSeatOccupied(Coordinate2D coordinate2D) {
        return (int) Arrays.stream(Direction2D.values())
                .map(d -> getNextSeat(coordinate2D, d))
                .filter(this::isOccupied)
                .count();
    }

    @Override
    public String toString() {
        return grid.toString();
    }
}
