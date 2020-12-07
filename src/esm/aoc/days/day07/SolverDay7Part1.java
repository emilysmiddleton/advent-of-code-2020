package esm.aoc.days.day07;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

import java.util.LinkedHashSet;
import java.util.Set;

public class SolverDay7Part1 {

    public static void main(String[] args) {
        DaySolver<Rules, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(7),
                new RulesParser(),
                new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<Rules, Integer> {
        @Override
        public Integer solve(Rules rules) {
            Set<String> colours = new LinkedHashSet<>();
            Bag shinyGold = rules.getBag("shiny gold");
            addContainers(rules, colours, shinyGold);
            return colours.size();
        }

        private void addContainers(Rules rules, Set<String> colours, Bag bag) {
            for (String parent : bag.getIsContainedBy()) {
                if (!colours.contains(parent)) {
                    colours.add(parent);
                    addContainers(rules, colours, rules.getBag(parent));
                }
            }
        }
    }

}
