package esm.aoc.days.day15;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private final Map<Integer, NumberRecord> records = new LinkedHashMap<>();
    private int index;
    private int previous;

    public Game(List<Integer> starting) {
        for (int i = 1; i <= starting.size(); i++) {
            records.put(starting.get(i - 1), new NumberRecord(i));
            previous = starting.get(i - 1);
        }
        index = starting.size() + 1;
    }

    public int getIndex() {
        return index;
    }

    public int next() {
        NumberRecord record = records.get(previous);
        int result = record.getValue();
        if (records.containsKey(result)) {
            records.get(result).record(index);
        } else {
            records.put(result, new NumberRecord(index));
        }
        previous = result;
        index++;
        return previous;
    }

}
