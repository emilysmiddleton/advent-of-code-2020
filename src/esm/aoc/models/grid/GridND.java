package esm.aoc.models.grid;

import java.util.Set;

public interface GridND<T> {
    void addItem(CoordinateND coordinate, T item);

    T getItem(CoordinateND coordinate);

    Set<CoordinateND> getCoordinates();
}