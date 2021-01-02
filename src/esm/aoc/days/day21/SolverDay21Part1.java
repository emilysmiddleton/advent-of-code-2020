package esm.aoc.days.day21;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SolverDay21Part1 implements Solver<Menu, Integer> {

    public static void main(String[] args) {
        DaySolver<Menu, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(21),
                new Parser(),
                new SolverDay21Part1()
        );
        System.out.println(daySolver.solve());
    }

    @Override
    public Integer solve(Menu menu) {
        Set<String> all = new LinkedHashSet<>();
        Map<String, Set<String>> allergyToFood = menu.getPossibilities();
        allergyToFood.entrySet().forEach(e -> all.addAll(e.getValue()));
        return menu.getAllItems().stream()
                .filter(item -> !all.contains(item))
                .mapToInt(item -> menu.getOccurrences(item).size())
                .sum();
    }

}
