package esm.aoc.models.grid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    void addCoordinateAndGetWithOriginalCoordinate() {
        Grid<String> grid = new Grid<>();
        Coordinate2D coordinate = new Coordinate2D(3, 6);
        grid.addItem(coordinate, "Hello");
        assertEquals("Hello", grid.getItem(coordinate));
    }

    @Test
    void addCoordinateAndGetWithEquivalentCoordinate() {
        Grid<String> grid = new Grid<>();
        Coordinate2D coordinate = new Coordinate2D(3, 6);
        grid.addItem(coordinate, "Hello");
        assertEquals("Hello", grid.getItem(new Coordinate2D(3, 6)));
    }

    @Test
    void addCoordinateAndGetWithXY() {
        Grid<String> grid = new Grid<>();
        Coordinate2D coordinate = new Coordinate2D(3, 6);
        grid.addItem(coordinate, "Hello");
        assertEquals("Hello", grid.getItem(3, 6));
    }

    @Test
    void addXYAndGetWithCoordinate() {
        Grid<String> grid = new Grid<>();
        grid.addItem(3, 6, "Hello");
        assertEquals("Hello", grid.getItem(new Coordinate2D(3, 6)));
    }

    @Test
    void addXYAndGetWithXY() {
        Grid<String> grid = new Grid<>();
        grid.addItem(3, 6, "Hello");
        assertEquals("Hello", grid.getItem(3, 6));
    }
}
