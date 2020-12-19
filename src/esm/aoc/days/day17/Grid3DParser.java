package esm.aoc.days.day17;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.transform.GridTransformer;
import esm.aoc.etl.transform.StringSeparatedTransformer;
import esm.aoc.etl.transform.Transformer;
import esm.aoc.models.grid.Coordinate3D;
import esm.aoc.models.grid.Grid;
import esm.aoc.models.grid.Grid3D;
import esm.aoc.models.grid.MapBackedGrid3D;

public class Grid3DParser implements Transformer<ConwayCube> {
    @Override
    public ConwayCube buildModel(PuzzleInput input) {
        GridTransformer<String> gridTransformer = new GridTransformer<>(StringSeparatedTransformer.NO_SEPARATOR, t -> t);
        Grid3D<String> grid = new MapBackedGrid3D();
        Grid<String> grid2d = gridTransformer.buildModel(input);
        grid2d.getCoordinates().forEach(c -> grid.addItem(new Coordinate3D(c.getX(), c.getY(), 0), grid2d.getItem(c)));
        return new ConwayCube(grid);
    }
}
