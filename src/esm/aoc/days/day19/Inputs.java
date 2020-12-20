package esm.aoc.days.day19;

import java.util.List;
import java.util.stream.Collectors;

public class Inputs {

    private List<String> inputs;
    private Rules rules;

    public Inputs(List<String> inputs, Rules rules) {
        this.inputs = inputs;
        this.rules = rules;
    }

    public Rules getRules() {
        return rules;
    }

    public List<String> getInputs() {
        return inputs;
    }
}
