package esm.aoc.days.day19;

import java.util.*;
import java.util.stream.Collectors;

public class Rules {
    private final Map<String, String> rules = new LinkedHashMap<>();
    private final Map<String, String> expandedRules = new LinkedHashMap<>();

    public void addRule(String rule) {
        String[] split = rule.split(": ");
        rules.put(split[0], split[1].replace("\"", ""));
    }

    public String getRule(String index) {
        return expand(rules.get(index));
    }
    public String expand(String rule) {
        if (expandedRules.containsKey(rule)) {
            return expandedRules.get(rule);
        }
        if (rules.containsKey(rule)) {
            return expand(rules.get(rule));
        }
        if (rule.contains(" | ")) {
            String[] or = rule.split(" \\| ");
            String result = "(" + Arrays.stream(or).map(this::expand).collect(Collectors.joining("|")) + ")";
            expandedRules.put(rule, result);
            return result;
        }
        if (rule.contains(" ")) {
            String[] sequence = rule.split(" ");
            String result = Arrays.stream(sequence).map(this::expand).collect(Collectors.joining(""));
            expandedRules.put(rule, result);
            return result;
        }
        expandedRules.put(rule, rule);
        return rule;
    }

    @Override
    public String toString() {
        return "Rules{" +
                "rules=" + rules +
                '}';
    }
}
