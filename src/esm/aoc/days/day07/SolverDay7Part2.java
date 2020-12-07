package esm.aoc.days.day07;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

import java.util.LinkedHashSet;
import java.util.Set;

public class SolverDay7Part2 {

    public static void main(String[] args) {
        DaySolver<Rules, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(7),
                new RulesParser(),
                new SolverPart2()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart2 implements Solver<Rules, Integer> {
        @Override
        public Integer solve(Rules rules) {
            return rules.getSize("shiny gold");
        }
    }

}
