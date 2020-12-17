package esm.aoc.days.day16;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

public class SolverDay16Part1 implements Solver<TrainModel, Integer> {

    public static void main(String[] args) {
        DaySolver<TrainModel, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(16),
                new Parser(),
                new SolverDay16Part1()
        );
        System.out.println(daySolver.solve());
    }

    @Override
    public Integer solve(TrainModel model) {
        int invalid = 0;
        for (Ticket ticket : model.getOtherTickets()) {
            for (int value : ticket.getFields()) {
                if (!isValid(model, value)) {
                    invalid += value;
                }
            }
        }
        return invalid;
    }

    private boolean isValid(TrainModel model, int value) {
        return model.getFields().stream().map(field -> field.isValid(value)).reduce(false, (a, b) -> a || b);
    }
}
