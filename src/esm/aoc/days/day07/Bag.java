package esm.aoc.days.day07;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Bag {

    private final String description;
    private final Map<String, Integer> contains = new LinkedHashMap<>();

    public Bag(String descripton) {
        this.description = descripton;
    }

    public void addContains(String bag, int quantity) {
        System.out.println(bag + " " + quantity);
        contains.put(bag, quantity);
    }

    @Override
    public String toString() {
        return description;
    }

}
