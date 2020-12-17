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
        for (Ticket ticket : model.getTickets()) {
            invalid += model.getInvalidFields(ticket).stream().mapToInt(i -> i).sum();
        }
        return invalid;
    }

}
