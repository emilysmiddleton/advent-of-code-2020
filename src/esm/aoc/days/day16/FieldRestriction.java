package esm.aoc.days.day16;

import esm.aoc.models.partition.Partition;

import java.util.Arrays;

public class FieldRestriction {

    private String field;
    private Partition[] partitions;

    public FieldRestriction(String field, Partition[] partitions) {
        this.field = field;
        this.partitions = partitions;
    }

    public boolean isValid(int value) {
        return Arrays.stream(partitions).map(p -> p.contains(value)).reduce(false, (a, b) -> a || b);
    }

    public String getField() {
        return field;
    }

    @Override
    public String toString() {
        return "FieldRestriction{" +
                "field='" + field + '\'' +
                ", partitions=" + Arrays.toString(partitions) +
                '}';
    }
}
