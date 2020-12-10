package esm.aoc.days.day10;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Adapters {

    private final List<Integer> adapters;
    private final Map<String, Long> cache = new LinkedHashMap<>();

    public Adapters(List<Integer> adapters) {
        this.adapters = adapters;
        this.adapters.add(0);
        this.adapters.sort(Integer::compareTo);
    }

    public long countArrangements() {
        return countArrangements(this.adapters);
    }

    private long countArrangements(List<Integer> list) {
        if (list.size() < 2) {
            return 1;
        }
        if (cache.containsKey(list.toString())) {
            return cache.get(list.toString());
        }
        long size = 0;
        int first = list.get(0);
        List<Integer> next = list.stream().filter(n -> n != first && n - first <= 3).collect(Collectors.toList());
        for (int n : next) {
            size += countArrangements(list.subList(list.indexOf(n), list.size()));
        }
        cache.put(list.toString(), size);
        return size;
    }
}
