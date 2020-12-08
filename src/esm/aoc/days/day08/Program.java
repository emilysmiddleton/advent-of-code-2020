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

    public void run() {
        System.out.println(instructions);
        while (!history.contains(this.pointer)) {
            history.add(this.pointer);
            instructions.get(pointer).apply(this);
        }
    }
}
