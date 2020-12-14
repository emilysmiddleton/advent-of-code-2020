package esm.aoc.days.day14;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SolverDay14Part1 {

    public static void main(String[] args) {
        DaySolver<List<Program>, Long> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(14),
                new ProgramParser(),
                new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<List<Program>, Long> {
        @Override
        public Long solve(List<Program> programs) {
            Bitmask bitmask = null;
            Map<Integer, Long> values = new LinkedHashMap<>();
            for (Program program : programs) {
                if (program.getBitmask() == null) {
                    Instruction instruction = program.getInstruction();
                    values.put(instruction.getIndex(), bitmask.mask(instruction.getValue()));
                } else {
                    bitmask = program.getBitmask();
                }
            }
            return values.entrySet().stream().mapToLong(entry -> entry.getValue()).sum();
        }
    }

}
