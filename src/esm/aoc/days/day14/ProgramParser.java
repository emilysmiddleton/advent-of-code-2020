package esm.aoc.days.day14;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.transform.Transformer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgramParser implements Transformer<List<Program>> {

    private static final Pattern instruction = Pattern.compile("mem\\[([0-9]+)\\] = ([0-9]+)");
    @Override
    public List<Program> buildModel(PuzzleInput input) {
        return input.transform(this::parse);
    }

    private Program parse(String input) {
        Matcher matcher = instruction.matcher(input);
        if (matcher.matches()) {
            Instruction instruction = new Instruction(Integer.parseInt(matcher.group(1)), Long.parseLong(matcher.group(2)));
            return new Program(null, instruction);
        }
        return new Program(input.replace("mask = ", ""), null);
    }
}
