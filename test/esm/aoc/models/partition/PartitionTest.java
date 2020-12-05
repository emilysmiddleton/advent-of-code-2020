package esm.aoc.models.partition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartitionTest {

    @Test
    void halfFirst() {
        Partition partition = new Partition(0, 8);
        partition.halve(true);
        assertEquals(0, partition.getMin());
        assertEquals(4, partition.getMax());
        assertEquals(4, partition.getSize());
    }

    @Test
    void halfLast() {
        Partition partition = new Partition(0, 8);
        partition.halve(false);
        assertEquals(4, partition.getMin());
        assertEquals(8, partition.getMax());
        assertEquals(4, partition.getSize());
    }
}
