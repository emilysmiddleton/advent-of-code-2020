package esm.aoc.days.day20;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.transform.GridTransformer;
import esm.aoc.etl.transform.StringSeparatedTransformer;
import esm.aoc.etl.transform.Transformer;
import esm.aoc.models.grid.Grid;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PuzzleParser implements Transformer<Pieces> {

    private static final Pattern ID_LINE = Pattern.compile("Tile (\\d+):");
    @Override
    public Pieces buildModel(PuzzleInput input) {
        int width = input.getLines().get(1).length();
        Pieces pieces = new Pieces(new LinkedHashMap<>());
        GridTransformer<String> gridTransformer = new GridTransformer<>(
                StringSeparatedTransformer.NO_SEPARATOR,
                s -> s
        );
        String id = "N/A";
        List<String> lines = new ArrayList<>();
        for (String line : input.getLines()) {
            Matcher matcher = ID_LINE.matcher(line);
            if (matcher.matches()) {
                id = matcher.group(1);
            } else if (line.isEmpty()) {
                Grid<String> grid = gridTransformer.buildModel(new PuzzleInput(lines));
                pieces.addPiece(new PuzzlePiece(
                        id,
                        getTop(width, grid),
                        getRight(width, grid),
                        getBottom(width, grid),
                        getLeft(width, grid)
                ));
                lines = new ArrayList<>();
            } else {
                lines.add(line);
            }
        }
        if (!lines.isEmpty()) {
            Grid<String> grid = gridTransformer.buildModel(new PuzzleInput(lines));
            pieces.addPiece(new PuzzlePiece(
                    id,
                    getTop(width, grid),
                    getRight(width, grid),
                    getBottom(width, grid),
                    getLeft(width, grid)
            ));
        }
        return pieces;
    }

    private String getTop(int width, Grid<String> grid) {
        StringBuilder builder = new StringBuilder();
        for (int x = 0; x < width; x++) {
            builder.append(grid.getItem(x, 0));
        }
        return builder.toString();
    }

    private String getRight(int width, Grid<String> grid) {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < width; y++) {
            builder.append(grid.getItem(width - 1, y));
        }
        return builder.toString();
    }

    private String getBottom(int width, Grid<String> grid) {
        StringBuilder builder = new StringBuilder();
        for (int x = 0; x < width; x++) {
            builder.append(grid.getItem(x, width - 1));
        }
        return builder.toString();
    }

    private String getLeft(int width, Grid<String> grid) {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < width; y++) {
            builder.append(grid.getItem(0, y));
        }
        return builder.toString();
    }

}
