package esm.aoc.days.day08;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.transform.Transformer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgramParser implements Transformer<Program> {

    private static final Pattern INSTRUCTION = Pattern.compile("(nop|acc|jmp) \\+?(.*)");
    @Override
    public Program buildModel(PuzzleInput input) {
        return new Program(input.transform(this::parseInstruction));
    }

    private Instruction parseInstruction(String line) {
        Matcher matcher = INSTRUCTION.matcher(line);
        if (matcher.matches()) {
            String code = matcher.group(1);
            int value = Integer.parseInt(matcher.group(2));
            switch (code) {
                case "acc": return new Accumalate(value);
                case "jmp": return new Jump(value);
                default: return new Nop();
            }
        }
        throw new IllegalArgumentException(line);
    }
}
