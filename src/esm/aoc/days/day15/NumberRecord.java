package esm.aoc.days.day15;

public class NumberRecord {

    private int last;
    private int penultimate = -1;
    private int count;

    public NumberRecord(int index) {
        last = index;
        count = 1;
    }
    public void record(int index) {
        penultimate = last;
        last = index;
        count++;
    }

    public int getValue() {
        return count == 1 ? 0 : last - penultimate;
    }
}
