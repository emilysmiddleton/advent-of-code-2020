package esm.aoc.days.day21;

import java.util.List;

public class MenuEntry {

    private final List<String> items;
    private final List<String> allergens;

    public MenuEntry(List<String> items, List<String> allergens) {
        this.items = items;
        this.allergens = allergens;
    }

    public List<String> getAllergens() {
        return allergens;
    }

    public List<String> getItems() {
        return items;
    }
}
