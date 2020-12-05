package esm.aoc.models.grid;

public interface Grid<T> {
    void addItem(Coordinate2D coordinate, T item);

    void addItem(int x, int y, T item);

    T getItem(Coordinate2D coordinate);

    T getItem(int x, int y);
}
