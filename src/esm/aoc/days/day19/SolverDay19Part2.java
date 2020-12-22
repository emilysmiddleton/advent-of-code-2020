package esm.aoc.days.day19;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolverDay19Part2 implements Solver<Inputs, Integer> {

    public static void main(String[] args) {
        DaySolver<Inputs, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(19),
                new RulesParser(),
                new SolverDay19Part2()
        );
        System.out.println(daySolver.solve());
    }

    @Override
    public Integer solve(Inputs inputs) {
        // 8: 42 | 42 8
        // 11: 42 31 | 42 11 31
        // 0: 8 11

        List<String> rules42 = inputs.getRules().getExpandedRules().get("42");
        List<String> rules31 = inputs.getRules().getExpandedRules().get("31");
        String rule42 = "(" + String.join("|", rules42) + ")";
        String rule31 = "(" + String.join("|", rules31) + ")";
        int count = 0;
        for (String input : inputs.getInputs()) {
            int chunkSize = rules42.get(0).length();
            if (input.length() % chunkSize == 0) {
                List<String> options = getOptions(input.length() / chunkSize, chunkSize, rule42, rule31);
                if (options.stream().anyMatch(s -> Pattern.compile(s).matcher(input).matches())) {
                    count++;
                }
            }
        }
        return count;
    }

    private List<String> getOptions(int chunks, int chunkSize, String rule42, String rule31) {
        List<String> options = new ArrayList<>();
        for (int i = 1 + chunks / 2; i < chunks; i++) {
            int j = chunks - i;
            options.add(rule42 + "{" + i + "}" + rule31 + "{" + j + "}");
        }
        return options;
    }

}