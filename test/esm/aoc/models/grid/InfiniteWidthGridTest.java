package esm.aoc.models.grid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InfiniteWidthGridTest {

    @Test
    void addGetRepeatedValue() {
        InfiniteWidthGrid<String> grid = new InfiniteWidthGrid<>(new MapBackedGrid<>(), 10);
        Coordinate2D coordinate = new Coordinate2D(3, 6);
        grid.addItem(coordinate, "Hello");
        assertEquals("Hello", grid.getItem(3, 6));
        assertEquals("Hello", grid.getItem(13, 6));
        assertEquals("Hello", grid.getItem(23, 6));
    }

}
