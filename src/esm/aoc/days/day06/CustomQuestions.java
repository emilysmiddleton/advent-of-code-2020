package esm.aoc.days.day06;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomQuestions {

    private final List<Set<String>>  answers = new ArrayList<>();

    public void addAnswers(String... answers) {
        this.answers.add(Set.of(answers));
    }

    private Set<String> getUnion() {
        Set<String> union  = new LinkedHashSet<>();
        answers.stream().forEach(union::addAll);
        return union;
    }

    private Set<String> getIntersection() {
        Set<String> intersection = new LinkedHashSet<>(answers.get(0));
        for (Set<String> set : answers) {
            intersection = intersection.stream().filter(set::contains).collect(Collectors.toSet());
        }
        return intersection;
    }

    public int unionSize() {
        return getUnion().size();
    }

    public int intersectionSize() {
        return getIntersection().size();
    }

    @Override
    public String toString() {
        return answers.toString();
    }
}
