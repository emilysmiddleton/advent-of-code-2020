package esm.aoc.models.partition;

public class Partition {

    private int min;
    private int max;

    public Partition(int min, int max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Reduce this partition size by half.
     * If first = true keep the lower half, else keep the other half.
     */
    public void halve(boolean first) {
        if (first) {
            max -= getSize() / 2;
        } else {
            min += getSize() / 2;
        }
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getSize() {
        return max - min;
    }

    public boolean contains(int value) {
        return value >= min && value <= max;
    }

    @Override
    public String toString() {
        return min + " - " + max;
    }
}
