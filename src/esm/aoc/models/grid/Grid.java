package esm.aoc.models.grid;

import java.util.LinkedHashMap;
import java.util.Map;

public class Grid<T> {

    private final Map<Coordinate2D, T> items = new LinkedHashMap<>();

    public void addItem(Coordinate2D coordinate, T item) {
        items.put(coordinate, item);
    }

    public void addItem(int x, int y, T item) {
        items.put(new Coordinate2D(x, y), item);
    }

    public T getItem(Coordinate2D coordinate) {
        return items.get(coordinate);
    }

    public T getItem(int x, int y) {
        return items.get(new Coordinate2D(x, y));
    }

}
