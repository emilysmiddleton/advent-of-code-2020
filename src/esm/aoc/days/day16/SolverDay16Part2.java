package esm.aoc.days.day16;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SolverDay16Part2 implements Solver<TrainModel, Long> {

    public static void main(String[] args) {
        DaySolver<TrainModel, Long> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(16),
                new Parser(),
                new SolverDay16Part2()
        );
        System.out.println(daySolver.solve());
    }

    @Override
    public Long solve(TrainModel model) {
        Map<Integer, List<String>> options = new LinkedHashMap<>();
        for (int i = 0; i < model.getFields().size(); i++) {
            List<Integer> values = model.getValuesAtPosition(i);
            List<String> fields = model.getFields().stream()
                    .filter(field -> matches(values, field))
                    .map(FieldRestriction::getField)
                    .collect(Collectors.toList());
            options.put(i, fields);
        }
        boolean todo = true;
        while (todo) {
            todo = reduce(options);
        }

        Ticket mine = model.getTickets().get(0);
        return options.entrySet().stream()
                .filter(e -> e.getValue().get(0).startsWith("departure"))
                .map(e -> (long) mine.getFields().get(e.getKey()))
                .reduce((long) 1, (a, b) -> a * b);
    }

    private boolean reduce(Map<Integer, List<String>> map) {
        List<String> singles = map.entrySet().stream()
                .filter(e -> e.getValue().size() == 1)
                .map(e -> e.getValue().get(0))
                .collect(Collectors.toList());
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                entry.getValue().removeAll(singles);
            }
        }
        return singles.size() < map.size();
    }

    private boolean matches(List<Integer> values, FieldRestriction field) {
        return values.stream().map(field::isValid).reduce(true, (a, b) -> a && b);
    }

}
