package esm.aoc.models.grid;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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

    @Override
    public Set<Coordinate2D> getCoordinates() {
        return items.keySet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapBackedGrid<?> that = (MapBackedGrid<?>) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public String toString() {
        return "MapBackedGrid{" +
                "items=" + items +
                '}';
    }
}
