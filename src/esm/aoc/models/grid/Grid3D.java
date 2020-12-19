package esm.aoc.models.grid;

import java.util.Set;

public interface Grid3D<T> {
    void addItem(Coordinate3D coordinate, T item);

    void addItem(int x, int y, int z, T item);

    T getItem(Coordinate3D coordinate);

    T getItem(int x, int y, int z);

    Set<Coordinate3D> getCoordinates();
}