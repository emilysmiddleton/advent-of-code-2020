package esm.aoc.days.day05;

import esm.aoc.models.partition.Partition;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Seat {

    private final List<Boolean> rowDescriptor;
    private final List<Boolean> columnDescriptor;

    public Seat(String descriptor) {
        rowDescriptor = Arrays.stream(descriptor.substring(0,  7)
                .split(""))
                .map("F"::equals).collect(Collectors.toList());
        columnDescriptor = Arrays.stream(descriptor.substring(7,  10)
                .split(""))
                .map("L"::equals).collect(Collectors.toList());
    }

    public int getRow() {
        return binaryPartition(rowDescriptor);
    }

    public int getColumn()  {
        return binaryPartition(columnDescriptor);
    }

    /**
     * multiply the row by 8, then add the column.
     */
    public int getID() {
        return getRow() * 8 + getColumn();
    }

    private int binaryPartition(List<Boolean> instructions) {
        Partition partition = new Partition(0, (int) Math.pow(2, instructions.size()));
        instructions.forEach(partition::halve);
        return partition.getMin();
    }

}
