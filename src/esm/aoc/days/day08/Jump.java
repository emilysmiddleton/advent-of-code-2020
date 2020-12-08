package esm.aoc.days.day08;

public class Jump implements Instruction {

    private final int value;

    public Jump(int value) {
        this.value = value;
    }

    @Override
    public void apply(Program program) {
        program.setPointer(program.getPointer() + value);
    }

    @Override
    public String toString() {
        return "jmp " + value;
    }
}
