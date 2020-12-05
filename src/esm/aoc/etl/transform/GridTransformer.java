package esm.aoc.etl.transform;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.models.grid.Grid;
import esm.aoc.models.grid.MapBackedGrid;

import java.util.List;

/**
 * Interprets the puzzle input as a grid, where each line is split up
 * into model objects according to the given parser.
 */
public class GridTransformer<T> implements Transformer<Grid<T>> {

    private final StringSeparatedTransformer lineParser;
    private final StringParser<T> transform;

    public GridTransformer(StringSeparatedTransformer lineParser, StringParser<T> transform) {
        this.lineParser = lineParser;
        this.transform = transform;
    }

    @Override
    public Grid<T> buildModel(PuzzleInput input) {
        Grid<T> grid = new MapBackedGrid<>();
        List<List<String>> separated  = lineParser.buildModel(input);
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
