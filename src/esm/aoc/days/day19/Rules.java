package esm.aoc.days.day19;

import java.util.*;
import java.util.stream.Collectors;

public class Rules {
    private final Map<String, String> rules = new LinkedHashMap<>();
    private final Map<String, List<String>> expandedRules = new LinkedHashMap<>();

    public void addRule(String rule) {
        String[] split = rule.split(": ");
        if (split[1].startsWith("\"")) {
            String normalised = split[1].replace("\"", "");
            expandedRules.put(split[0], List.of(normalised));
            rules.put(split[0], normalised);
        }
        rules.put(split[0], split[1]);
    }

    public void expand() {
        while (expandedRules.size() < rules.size()) {
            rules.entrySet().stream()
                    .filter(e -> !expandedRules.containsKey(e.getKey()) && expandable(e.getValue()))
                    .forEach(e -> expand(e.getKey(), e.getValue()));
        }
    }

    private void expand(String key, String value) {
        List<String> result = new ArrayList<>();
        if (value.contains("|")) {
            String[] split = value.split(" \\| ");
            result.addAll(expand(split[0]));
            result.addAll(expand(split[1]));
        } else {
            result.addAll(expand(value));
        }
        expandedRules.put(key, result);
    }

    public List<String> expand(String value) {
        String[] split = value.split(" ");
        if (split.length == 1) {
            return expandedRules.get(split[0]);
        }
        List<String> combined = new ArrayList<>();
        for (String left : expandedRules.get(split[0])) {
            for (String right : expandedRules.get(split[1])) {
                combined.add(left + right);
            }
        }
        return combined;
    }

    private boolean expandable(String value) {
        String[] keys = value.split("[ |]+");
        return Arrays.stream(keys).allMatch(expandedRules::containsKey);
    }

    public Map<String, List<String>> getExpandedRules() {
        return expandedRules;
    }

    @Override
    public String toString() {
        return "Rules{" +
                "rules=" + rules +
                '}';
    }
}
