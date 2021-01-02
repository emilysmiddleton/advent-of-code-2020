package esm.aoc.days.day21;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.transform.Transformer;

import java.util.List;

public class Parser implements Transformer<Menu> {

    @Override
    public Menu buildModel(PuzzleInput input) {
        return new Menu(input.transform(this::parse));
    }

    private MenuEntry parse(String line) {
        int index = line.indexOf(" (contains");
        String items = line.substring(0, index);
        String allergens = line.substring(index + 11, line.length() - 1);
        return new MenuEntry(List.of(items.split(" ")), List.of(allergens.split(", ")));
    }
}
