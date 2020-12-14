package esm.aoc.days.day14;

import java.util.List;

public class Program {

    private final Bitmask bitmask;
    private final Instruction instruction;

    public Program(Bitmask bitmask, Instruction instruction) {
        this.bitmask = bitmask;
        this.instruction = instruction;
    }

    public Bitmask getBitmask() {
        return bitmask;
    }

    public Instruction getInstruction() {
        return instruction;
    }
}
