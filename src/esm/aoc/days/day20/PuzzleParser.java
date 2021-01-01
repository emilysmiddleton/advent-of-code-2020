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
        int pieceWidth = input.getLines().get(1).length();
        int totalPieces = (input.getLines().size() + 1) / (pieceWidth + 2);
        int puzzleSize = (int) Math.sqrt(totalPieces);
        Pieces pieces = new Pieces(pieceWidth, totalPieces, puzzleSize, new LinkedHashMap<>());
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
                        0,
                        false,
                        pieceWidth,
                        grid
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
                    0,
                    false,
                    pieceWidth,
                    grid
            ));
        }
        return pieces;
    }
}
