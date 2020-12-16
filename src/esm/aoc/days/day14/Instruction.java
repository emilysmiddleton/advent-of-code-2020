package esm.aoc.days.day14;

public class Instruction {

    private int index;
    private Long value;

    public Instruction(int index, Long value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public Long getValue() {
        return value;
    }
}
