package esm.aoc.days.day02;

import esm.aoc.etl.DaySolver;
import esm.aoc.etl.extract.PuzzleInputExtractor;
import esm.aoc.etl.solve.Solver;

import java.util.Arrays;
import java.util.List;

public class SolverDay2Part1 {

    public static void main(String[] args) {
        DaySolver<List<PasswordPolicy>, Integer> daySolver = new DaySolver<>(
                new PuzzleInputExtractor(2),
                new PasswordParser(),
                new SolverPart1()
        );
        System.out.println(daySolver.solve());
    }

    private static class SolverPart1 implements Solver<List<PasswordPolicy>, Integer> {
        @Override
        public Integer solve(List<PasswordPolicy> passwords) {
            return (int) passwords.stream().filter(this::isValid).count();
        }
        public boolean isValid(PasswordPolicy policy) {
            int count = countOccurrences(policy.getCharacter(), policy.getPassword());
            return count >= policy.getFirst() && count <= policy.getSecond();
        }

        private int countOccurrences(String character, String password) {
            return (int) Arrays.stream(password.split(""))
                    .filter(character::equals)
                    .count();
        }
    }


}
