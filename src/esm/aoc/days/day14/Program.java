package esm.aoc.days.day14;

public class Program {

    private final String bitmask;
    private final Instruction instruction;

    public Program(String bitmask, Instruction instruction) {
        this.bitmask = bitmask;
        this.instruction = instruction;
    }

    public String getBitmask() {
        return bitmask;
    }

    public Instruction getInstruction() {
        return instruction;
    }
}
