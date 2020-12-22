package esm.aoc.days.day20;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.transform.GridTransformer;
import esm.aoc.etl.transform.StringSeparatedTransformer;
import esm.aoc.etl.transform.Transformer;
import esm.aoc.models.grid.Grid;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PuzzleParser implements Transformer<Pieces> {
    private static final Pattern ID_LINE = Pattern.compile("Tile (\\d+):");
    @Override
    public Pieces buildModel(PuzzleInput input) {
        Pieces pieces = new Pieces();
        GridTransformer<String> gridTransformer = new GridTransformer<>(
            StringSeparatedTransformer.NO_SEPARATOR,
            s -> s
        );
        int id = -1;
        List<String> lines = new ArrayList<>();
        for (String line : input.getLines()) {
            Matcher matcher = ID_LINE.matcher(line);
            if (matcher.matches()) {
                id = Integer.parseInt(matcher.group(1));
            } else if (line.isEmpty()) {
                Grid<String> grid = gridTransformer.buildModel(new PuzzleInput(lines));
                pieces.addPiece(new GridPuzzlePiece(id, 9, grid));
                lines = new ArrayList<>();
            } else {
                lines.add(line);
            }
        }
        return pieces;
    }
}
