package esm.aoc.days.day21;

import java.util.*;
import java.util.stream.Collectors;

public class Menu {

    private List<MenuEntry> entries;
    private Set<String> allAllergens = new LinkedHashSet<>();
    private Set<String> allItems = new LinkedHashSet<>();
    private Map<String, Set<String>> possibilities = new LinkedHashMap<>();

    public Menu(List<MenuEntry> entries) {
        this.entries = entries;
        for (MenuEntry entry : entries) {
            List<String> items = entry.getItems();
            allAllergens.addAll(entry.getAllergens());
            allItems.addAll(items);
            for (String allergy : entry.getAllergens()) {
                if (possibilities.containsKey(allergy)) {
                    Set<String> existing = possibilities.get(allergy);
                    Set<String> union = existing.stream().filter(items::contains).collect(Collectors.toSet());
                    possibilities.put(allergy, union);
                } else {
                    possibilities.put(allergy, new LinkedHashSet<>(items));
                }
            }
        }
    }

    public Map<String, Set<String>> getPossibilities() {
        return possibilities;
    }

    public Set<String> getAllItems() {
        return allItems;
    }

    public Set<String> getAllAllergens() {
        return allAllergens;
    }

    public Set<MenuEntry> getOccurrences(String item) {
        return entries.stream().filter(entry -> entry.getItems().contains(item)).collect(Collectors.toSet());
    }
}
