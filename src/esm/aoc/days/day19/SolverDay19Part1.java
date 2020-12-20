package esm.aoc.days.day19;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

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
        Pattern rule = Pattern.compile(inputs.getRules().getRule("0"));
        System.out.println(rule);
        return inputs.getInputs().stream()
                .filter(s -> rule.matcher(s).matches())
                .collect(Collectors.toList()).size();
    }
}
