package esm.aoc.days.day17;

import esm.aoc.models.grid.Coordinate3D;
import esm.aoc.models.grid.Grid3D;
import esm.aoc.models.grid.MapBackedGrid3D;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ConwayCube {

    private Grid3D<String> grid;

    public ConwayCube(Grid3D<String> grid) {
        this.grid = grid;
    }

    public ConwayCube next() {
        Grid3D<String> newGrid = new MapBackedGrid3D<>();
        for (Coordinate3D coord : getActive()) {
            Set<Coordinate3D> adjacentActive = getAdjacentActive(coord);
            if (adjacentActive.size() == 2 || adjacentActive.size() == 3) {
                newGrid.addItem(coord, "#");
            }
        }
        for (Coordinate3D coord : getInactive()) {
            Set<Coordinate3D> adjacentActive = getAdjacentActive(coord);
            if (adjacentActive.size() == 3) {
                newGrid.addItem(coord, "#");
            }
        }
        return new ConwayCube(newGrid);
    }

    public Set<Coordinate3D> getActive() {
        return grid.getCoordinates().stream().filter(this::isActive).collect(Collectors.toSet());
    }

    public Set<Coordinate3D> getInactive() {
        Set<Coordinate3D> active = getActive();
        Set<Coordinate3D> inactive = new LinkedHashSet<>();
        active.forEach(c -> inactive.addAll(getAdjacentInactive(c)));
        return inactive;
    }

    public Set<Coordinate3D> getAdjacentActive(Coordinate3D coord) {
        return coord.getAdjacent().stream().filter(this::isActive).collect(Collectors.toSet());
    }

    public Set<Coordinate3D> getAdjacentInactive(Coordinate3D coord) {
        return coord.getAdjacent().stream().filter(this::isInactive).collect(Collectors.toSet());
    }

    private boolean isActive(Coordinate3D coord) {
        return "#".equals(grid.getItem(coord));
    }

    private boolean isInactive(Coordinate3D coord) {
        return !isActive(coord);
    }

    @Override
    public String toString() {
        return grid.toString();
    }
}
