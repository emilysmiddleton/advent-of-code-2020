package esm.aoc.parse;

import esm.aoc.models.grid.Coordinate2D;
import esm.aoc.models.grid.Grid;

import java.util.List;

public class GridParser<T> {

    private SeparatedLineParser lineParser;
    private Transform<T> transform;

    public GridParser(SeparatedLineParser lineParser, Transform<T> transform) {
        this.lineParser = lineParser;
        this.transform = transform;
    }

    public Grid<T> getGrid(List<String> lines) {
        Grid<T> grid = new Grid<>();
        List<List<String>> separated  = lineParser.parse(lines);
        int y = 0;
        for (List<String> row : separated) {
            int x = 0;
            for (String str : row) {
                T item = transform.transform(str);
                grid.addItem(x, y, item);
                x++;
            }
            y++;
        }
        return grid;
    }
}
