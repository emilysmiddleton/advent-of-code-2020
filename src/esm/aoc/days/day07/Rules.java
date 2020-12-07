package esm.aoc.days.day07;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rules {

    private static final Pattern LINE = Pattern.compile("(.+ .+) bags contain (.+,?)+.");
    private static final Pattern CONTENT = Pattern.compile("([0-9]+) (.+ .+) bags?");

    private final Map<String, Bag> bags = new LinkedHashMap<>();

    private Bag addBag(String description) {
        if (!bags.containsKey(description)) {
            bags.put(description, new Bag(description));
        }
        return bags.get(description);
    }

    public Bag getBag(String description) {
        return bags.get(description);
    }

    public void addRule(String rule) {
        Matcher matcher = LINE.matcher(rule);
        if (matcher.matches()) {
            String description = matcher.group(1);
            Bag bag = addBag(description);
            addContains(bag, matcher.group(2));
        }
    }

    public int getSize(String description) {
        Bag bag = getBag(description);
        int sum = 0;
        for (String child : bag.getChildren()) {
            sum += bag.getChildNumber(child) * (getSize(child) + 1);
        }
        return sum;
    }

    private void addContains(Bag bag, String contains) {
        if ("no other bags".equals(contains)) {
            return;
        }
        for (String child : contains.split(", ")) {
            Matcher matcher = CONTENT.matcher(child);
            if (matcher.matches()) {
                int count = Integer.parseInt(matcher.group(1));
                String description = matcher.group(2);
                Bag childBag = addBag(description);
                bag.addContains(description, count);
                childBag.addIsContainedBy(bag.getDescription());
            }
        }
    }
}
