package esm.aoc.models.grid;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapBackedGrid<T> implements Grid<T> {

    private final Map<Coordinate2D, T> items = new LinkedHashMap<>();

    @Override
    public void addItem(Coordinate2D coordinate, T item) {
        items.put(coordinate, item);
    }

    @Override
    public final void addItem(int x, int y, T item) {
        addItem(new Coordinate2D(x, y), item);
    }

    @Override
    public T getItem(Coordinate2D coordinate) {
        return items.get(coordinate);
    }

    @Override
    public final T getItem(int x, int y) {
        return getItem(new Coordinate2D(x, y));
    }

}
