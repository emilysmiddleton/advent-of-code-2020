package esm.aoc.days.day03;

import com.sun.tools.jconsole.JConsoleContext;
import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;
import esm.aoc.etl.transform.GridTransformer;
import esm.aoc.etl.transform.StringParser;
import esm.aoc.etl.transform.StringSeparatedTransformer;
import esm.aoc.models.grid.Coordinate2D;
import esm.aoc.models.grid.Direction2D;
import esm.aoc.models.grid.Grid;

public class SolverDay3Part1 {

    public static void main(String[] args) {
        DaySolver<Grid<String>, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(3),
                new GridTransformer<>(
                        StringSeparatedTransformer.NO_SEPARATOR,
                        StringParser.PASS_THROUGH
                ),
                new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<Grid<String>, Integer> {
        @Override
        public Integer solve(Grid<String> grid) {
            int trees = 0;
            Coordinate2D coord = new Coordinate2D(0, 0);
            String entry = grid.getItem(coord);
            while (entry != null) {
                if ("#".equals(entry)) {
                    trees++;
                }
                coord = coord.move(Direction2D.RIGHT, 3).move(Direction2D.DOWN, 1);
                // Reduce the x coordinate module 31 (th width of the grid given) as the grid reepeats.
                coord = new Coordinate2D(coord.getX() % 31, coord.getY());
                entry = grid.getItem(coord);
            }
            return trees;
        }
    }

}
