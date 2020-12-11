package esm.aoc.models.grid;

import java.util.Set;

public interface Grid<T> {
    void addItem(Coordinate2D coordinate, T item);

    void addItem(int x, int y, T item);

    T getItem(Coordinate2D coordinate);

    T getItem(int x, int y);

    Set<Coordinate2D> getCoordinates();
}
