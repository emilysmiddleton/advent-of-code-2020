package esm.aoc.days.day08;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Program {
    private int accumulator = 0;
    private int pointer = 0;
    private final List<Instruction> instructions;
    private final Set<Integer> history = new LinkedHashSet<>();

    public Program(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public int getAccumulator() {
        return accumulator;
    }

    public void setAccumulator(int accumulator) {
        this.accumulator = accumulator;
    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public boolean run() {
        while (!history.contains(pointer) && pointer < instructions.size() ) {
            history.add(pointer);
            instructions.get(pointer).apply(this);
        }
        return pointer >= instructions.size();
    }
}
