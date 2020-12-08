package esm.aoc.days.day08;

public class Nop implements Instruction {

    @Override
    public void apply(Program program) {
        program.setPointer(program.getPointer() + 1);
    }

    @Override
    public String toString() {
        return "nop";
    }
}
