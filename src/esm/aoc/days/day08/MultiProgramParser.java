package esm.aoc.days.day08;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.transform.Transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiProgramParser implements Transformer<List<Program>> {
    @Override
    public List<Program> buildModel(PuzzleInput input) {
        List<Program> programs = new ArrayList<>();
        ProgramParser parser = new ProgramParser();
        for (int i = 0; i < input.getLines().size(); i++) {
            String[] copy = input.getLines().toArray(new String[0]);
            if (copy[i].startsWith("nop")) {
                copy[i] = copy[i].replace("nop", "jmp");
            }
            if (copy[i].startsWith("jmp")) {
                copy[i] = copy[i].replace("jmp", "nop");
            }
            programs.add(parser.buildModel(new PuzzleInput(Arrays.asList(copy))));
        }
        return programs;
    }
}
