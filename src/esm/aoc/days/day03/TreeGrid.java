package esm.aoc.days.day03;

import esm.aoc.etl.transform.GridTransformer;
import esm.aoc.etl.transform.StringParser;
import esm.aoc.etl.transform.StringSeparatedTransformer;
import esm.aoc.etl.transform.Transformer;
import esm.aoc.models.grid.Coordinate2D;
import esm.aoc.models.grid.Direction2D;
import esm.aoc.models.grid.Grid;
import esm.aoc.models.grid.InfiniteWidthGrid;

public class TreeGrid {

    public static Transformer<TreeGrid> TRANSFORM = input -> {
        Grid<String> grid = new GridTransformer<>(
                StringSeparatedTransformer.NO_SEPARATOR,
                StringParser.PASS_THROUGH
        ).buildModel(input);
        int width = input.getLines().get(0).length();
        return new TreeGrid(new InfiniteWidthGrid<>(grid, width));
    };

    private final Grid<String> grid;

    public TreeGrid(Grid<String> grid) {
        this.grid = grid;
    }

    public int countTrees( int right, int down) {
        int trees = 0;
        Coordinate2D coord = new Coordinate2D(0, 0);
        String entry = this.grid.getItem(coord);
        while (entry != null) {
            if ("#".equals(entry)) {
                trees++;
            }
            coord = coord.move(Direction2D.RIGHT, right).move(Direction2D.DOWN, down);
            entry = this.grid.getItem(coord);
        }
        return trees;
    }
}
