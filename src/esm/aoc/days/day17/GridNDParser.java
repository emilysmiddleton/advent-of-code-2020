package esm.aoc.days.day17;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.transform.GridTransformer;
import esm.aoc.etl.transform.StringSeparatedTransformer;
import esm.aoc.etl.transform.Transformer;
import esm.aoc.models.grid.*;

import java.util.ArrayList;
import java.util.List;

public class GridNDParser implements Transformer<ConwayCube> {

    private int dimensions;

    public GridNDParser(int dimensions) {
        this.dimensions = dimensions;
    }

    private CoordinateND getCoord(Coordinate2D twoD) {
        List<Integer> indexes = new ArrayList<>(List.of(twoD.getX(), twoD.getY()));
        for (int axis = 2; axis < dimensions; axis++) {
            indexes.add(0);
        }
        return new CoordinateND(indexes);
    }

    @Override
    public ConwayCube buildModel(PuzzleInput input) {
        GridTransformer<String> gridTransformer = new GridTransformer<>(StringSeparatedTransformer.NO_SEPARATOR, t -> t);
        GridND<String> grid = new MapBackedGridND();
        Grid<String> grid2d = gridTransformer.buildModel(input);
        grid2d.getCoordinates().forEach(c -> grid.addItem(getCoord(c), grid2d.getItem(c)));
        return new ConwayCube(grid);
    }
}
