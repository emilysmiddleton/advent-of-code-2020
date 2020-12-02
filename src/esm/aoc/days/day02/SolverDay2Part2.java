package esm.aoc.days.day02;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;

import java.util.List;

public class SolverDay2Part2 {

    public static void main(String[] args) {
        DaySolver<List<PasswordPolicy>, Integer> daySolver = new DaySolver<>(
            new PuzzleInputExtractor(2),
            new PasswordParser(),
            new SolverPart2()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart2 implements esm.aoc.etl.solve.Solver<List<PasswordPolicy>, Integer> {
        @Override
        public Integer solve(List<PasswordPolicy> passwords) {
            return (int) passwords.stream().filter(this::isValid).count();
        }

        public boolean isValid(PasswordPolicy policy) {
            String characterA = policy.getPassword().substring(policy.getFirst() - 1, policy.getFirst());
            String characterB = policy.getPassword().substring(policy.getSecond() - 1, policy.getSecond());
            return policy.getCharacter().equals(characterA) ^ policy.getCharacter().equals(characterB);
        }
    }

}
