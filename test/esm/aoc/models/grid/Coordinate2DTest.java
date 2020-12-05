package esm.aoc.models.grid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Coordinate2DTest {

    @Test
    void moveUp() {
        Coordinate2D start = new Coordinate2D(1, 2);
        Coordinate2D end = start.move(Direction2D.UP, 5);
        assertEquals(new Coordinate2D(1, -3), end);
    }

    @Test
    void moveDown() {
        Coordinate2D start = new Coordinate2D(1, 2);
        Coordinate2D end = start.move(Direction2D.DOWN, 5);
        assertEquals(new Coordinate2D(1, 7), end);
    }

    @Test
    void moveLeft() {
        Coordinate2D start = new Coordinate2D(1, 2);
        Coordinate2D end = start.move(Direction2D.LEFT, 5);
        assertEquals(new Coordinate2D(-4, 2), end);
    }

    @Test
    void moveRight() {
        Coordinate2D start = new Coordinate2D(1, 2);
        Coordinate2D end = start.move(Direction2D.RIGHT, 5);
        assertEquals(new Coordinate2D(6, 2), end);
    }
}
