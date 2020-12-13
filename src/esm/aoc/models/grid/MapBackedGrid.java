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

    private int getMaxX() {
        return getCoordinates().stream().mapToInt(Coordinate2D::getX).max().orElse(0);
    }

    private int getMaxY() {
        return getCoordinates().stream().mapToInt(Coordinate2D::getY).max().orElse(0);
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
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < getMaxY(); y++) {
            for (int x = 0; x < getMaxX(); x++) {
                T value = getItem(x, y);
                builder.append(value == null ? " " : value);
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
