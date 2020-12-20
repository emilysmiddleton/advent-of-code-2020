package esm.aoc.days.day19;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.transform.Transformer;

import java.util.ArrayList;
import java.util.List;

public class RulesParser implements Transformer<Inputs> {

    @Override
    public Inputs buildModel(PuzzleInput input) {
        boolean first = true;
        Rules rules = new Rules();
        List<String> inputs = new ArrayList<>();
        for (String line : input.getLines()) {
            if (line.isEmpty()) {
                first = false;
            } else {
                if (first) {
                    rules.addRule(line);
                } else {
                    inputs.add(line);
                }
            }
        }
        return new Inputs(inputs, rules);
    }
}
