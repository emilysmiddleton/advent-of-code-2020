package esm.aoc.days.day08;

public class Accumalate implements Instruction {

    private final int value;

    public Accumalate(int value) {
        this.value = value;
    }

    @Override
    public void apply(Program program) {
        program.setAccumulator(program.getAccumulator() + value);
        program.setPointer(program.getPointer() + 1);
    }

    @Override
    public String toString() {
        return "acc " + value;
    }
}
