package esm.aoc.models.grid;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MapBackedGrid3D<T> implements Grid3D<T> {

    private final Map<Coordinate3D, T> items = new LinkedHashMap<>();

    @Override
    public void addItem(Coordinate3D coordinate, T item) {
        items.put(coordinate, item);
    }

    @Override
    public final void addItem(int x, int y, int z, T item) {
        addItem(new Coordinate3D(x, y, z), item);
    }

    @Override
    public T getItem(Coordinate3D coordinate) {
        return items.get(coordinate);
    }

    @Override
    public final T getItem(int x, int y, int z) {
        return getItem(new Coordinate3D(x, y, z));
    }

    @Override
    public Set<Coordinate3D> getCoordinates() {
        return items.keySet();
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
