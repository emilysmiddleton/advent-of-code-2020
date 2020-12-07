package esm.aoc.days.day07;

import java.util.*;

public class Bag {

    private final String description;
    private final Set<String> isContainedBy = new LinkedHashSet<>();
    private final Map<String, Integer> contains = new LinkedHashMap<>();

    public Bag(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void addIsContainedBy(String bag) {
        isContainedBy.add(bag);
    }

    public void addContains(String bag, int quantity) {
        contains.put(bag, quantity);
    }

    public Set<String> getIsContainedBy() {
        return isContainedBy;
    }

    public Set<String> getChildren() {
        return contains.keySet();
    }

    public int getChildNumber(String description) {
        return contains.get(description);
    }

    @Override
    public String toString() {
        return description;
    }

}
