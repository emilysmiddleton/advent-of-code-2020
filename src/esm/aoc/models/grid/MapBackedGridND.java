package esm.aoc.models.grid;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MapBackedGridND<T> implements GridND<T> {

    private final Map<CoordinateND, T> items = new LinkedHashMap<>();

    @Override
    public void addItem(CoordinateND coordinate, T item) {
        items.put(coordinate, item);
    }

    @Override
    public T getItem(CoordinateND coordinate) {
        return items.get(coordinate);
    }

    @Override
    public Set<CoordinateND> getCoordinates() {
        return items.keySet();
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
