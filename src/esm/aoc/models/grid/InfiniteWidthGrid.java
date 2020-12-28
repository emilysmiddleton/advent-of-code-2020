package esm.aoc.models.grid;

import java.util.Set;

public class InfiniteWidthGrid<T> implements Grid<T> {

    private int repeatWidth;
    private Grid<T> grid;

    public InfiniteWidthGrid(Grid<T> grid, int repeatWidth) {
        this.grid = grid;
        this.repeatWidth = repeatWidth;
    }

    @Override
    public void removeItem(int x, int y) {
        grid.removeItem(x, y);
    }

    @Override
    public void addItem(Coordinate2D coordinate, T item) {
        grid.addItem(coordinate, item);
    }

    @Override
    public void addItem(int x, int y, T item) {
        grid.addItem(x, y, item);
    }

    @Override
    public T getItem(int x, int y) {
        return grid.getItem(x % repeatWidth, y);
    }

    public T getItem(Coordinate2D coordinate) {
        return getItem(coordinate.getX(), coordinate.getY());
    }

    @Override
    public Set<Coordinate2D> getCoordinates() {
        return grid.getCoordinates();
    }
}
