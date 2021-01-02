package esm.aoc.days.day21;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

import java.util.*;
import java.util.stream.Collectors;

public class SolverDay21Part2 implements Solver<Menu, String> {

    public static void main(String[] args) {
        DaySolver<Menu, String> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(21),
                new Parser(),
                new SolverDay21Part2()
        );
        System.out.println(daySolver.solve());
    }

    @Override
    public String solve(Menu menu) {
        Map<String, Set<String>> allergyToFood = menu.getPossibilities();
        Map<String, String> mapping = new LinkedHashMap<>();
        while (!allergyToFood.isEmpty()) {
            for (String key : new LinkedHashSet<>(allergyToFood.keySet())) {
                Set<String> values = allergyToFood.get(key);
                if (values.size() == 1) {
                    String item = values.iterator().next();
                    mapping.put(key, item);
                    allergyToFood.remove(key);
                    allergyToFood.entrySet().forEach(entry -> entry.getValue().remove(item));
                }
            }
        }
        List<String> allergens = new ArrayList<>(mapping.keySet());
        allergens.sort(String::compareTo);
        return allergens.stream().map(mapping::get).collect(Collectors.joining(","));
    }

}