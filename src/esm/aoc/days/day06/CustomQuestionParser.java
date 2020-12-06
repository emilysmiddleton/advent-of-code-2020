package esm.aoc.days.day06;

import esm.aoc.days.day04.Passport;
import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.transform.Transformer;

import java.util.ArrayList;
import java.util.List;

public class CustomQuestionParser implements Transformer<List<CustomQuestions>> {

    @Override
    public List<CustomQuestions> buildModel(PuzzleInput input) {
        List<CustomQuestions> questions = new ArrayList<>();
        CustomQuestions current = new CustomQuestions();
        for (String line : input.getLines()) {
            if (line.length() == 0) {
                questions.add(current);
                current = new CustomQuestions();
            } else {
                String[] answers = line.split("");
                current.addAnswers(answers);
            }
        }
        questions.add(current);
        return questions;
    }

}
