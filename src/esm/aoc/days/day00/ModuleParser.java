package esm.aoc.days.day00;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.transform.IntegersTransformer;
import esm.aoc.etl.transform.Transformer;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Each line in the input is a single integer representing the mass of the module.
 * Convert each line to an integer and wrap in a module.
 */
public class ModuleParser implements Transformer<List<Module>> {

    @Override
    public List<Module> buildModel(PuzzleInput lines) {
        List<Integer> masses = IntegersTransformer.TO_INTEGERS.buildModel(lines);
        return masses.stream().map(Module::new).collect(Collectors.toList());
    }

}
