package esm.aoc.days.day19;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SolverDay19Part1 implements Solver<Inputs, Integer> {

    public static void main(String[] args) {
        DaySolver<Inputs, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(19),
                new RulesParser(),
                new SolverDay19Part1()
        );
        System.out.println(daySolver.solve());
    }

    @Override
    public Integer solve(Inputs inputs) {
        List<String> values = inputs.getRules().getExpandedRules().get("0");
        return inputs.getInputs().stream().filter(values::contains).collect(Collectors.toList()).size();
    }
}
