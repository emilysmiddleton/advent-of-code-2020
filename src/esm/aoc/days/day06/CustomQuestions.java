package esm.aoc.days.day06;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CustomQuestions {

    private final Set<String> answers = new LinkedHashSet<>();

    public void addAnswers(String... answers) {
        this.answers.addAll(List.of(answers));
    }

    public int size() {
        return answers.size();
    }

    @Override
    public String toString() {
        return answers.toString();
    }
}
