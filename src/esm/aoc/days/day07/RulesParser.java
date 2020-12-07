package esm.aoc.days.day07;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.transform.Transformer;

public class RulesParser implements Transformer<Rules> {

    @Override
    public Rules buildModel(PuzzleInput input) {
        Rules rules = new Rules();
        input.getLines().forEach(rules::addRule);
        return rules;
    }
}
