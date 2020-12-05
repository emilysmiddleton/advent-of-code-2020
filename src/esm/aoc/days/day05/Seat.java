package esm.aoc.days.day05;

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
        int min = 0;
        int max = (int) Math.pow(2, instructions.size());
        int partitionSize = max;
        for (boolean instruction : instructions) {
            partitionSize = partitionSize / 2;
            if (instruction) {
                max = max - partitionSize;
            }  else {
                min = min + partitionSize;
            }
        }
        return min;
    }

}
