package esm.aoc.days.day17;

import esm.aoc.models.grid.Coordinate3D;
import esm.aoc.models.grid.CoordinateND;
import esm.aoc.models.grid.GridND;
import esm.aoc.models.grid.MapBackedGridND;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ConwayCube {

    private GridND<String> grid;

    public ConwayCube(GridND<String> grid) {
        this.grid = grid;
    }

    public ConwayCube next() {
        GridND<String> newGrid = new MapBackedGridND<>();
        for (CoordinateND coord : getActive()) {
            Set<CoordinateND> adjacentActive = getAdjacentActive(coord);
            if (adjacentActive.size() == 2 || adjacentActive.size() == 3) {
                newGrid.addItem(coord, "#");
            }
        }
        for (CoordinateND coord : getInactive()) {
            Set<CoordinateND> adjacentActive = getAdjacentActive(coord);
            if (adjacentActive.size() == 3) {
                newGrid.addItem(coord, "#");
            }
        }
        return new ConwayCube(newGrid);
    }

    public Set<CoordinateND> getActive() {
        return grid.getCoordinates().stream().filter(this::isActive).collect(Collectors.toSet());
    }

    public Set<CoordinateND> getInactive() {
        Set<CoordinateND> active = getActive();
        Set<CoordinateND> inactive = new LinkedHashSet<>();
        active.forEach(c -> inactive.addAll(getAdjacentInactive(c)));
        return inactive;
    }

    public Set<CoordinateND> getAdjacentActive(CoordinateND coord) {
        return coord.getAdjacent().stream().filter(this::isActive).collect(Collectors.toSet());
    }

    public Set<CoordinateND> getAdjacentInactive(CoordinateND coord) {
        return coord.getAdjacent().stream().filter(this::isInactive).collect(Collectors.toSet());
    }

    private boolean isActive(CoordinateND coord) {
        return "#".equals(grid.getItem(coord));
    }

    private boolean isInactive(CoordinateND coord) {
        return !isActive(coord);
    }

    @Override
    public String toString() {
        return grid.toString();
    }
}
