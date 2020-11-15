package esm.aoc.days.day00;

public class Module {
    private final int mass;

    public Module(int mass) {
        this.mass = mass;
    }

    /**
     * Fuel required to launch a given module is based on its mass.
     * Specifically, to find the fuel required for a module,
     * take its mass, divide by three, round down, and subtract 2.
     */
    public int getFuelRequirementsPart1() {
        return calculateFuel(mass);
    }

    /**
     * Fuel itself requires fuel just like a module -
     * take its mass, divide by three, round down, and subtract 2.
     * However, that fuel also requires fuel, and that fuel requires fuel, and so on.
     * Any mass that would require negative fuel should instead be treated as if it requires zero fuel;
     */
    public int getFuelRequirementsPart2() {
        int input =  mass;
        int total = 0;
        while (input > 0) {
            input = calculateFuel(input);
            total += input;
        }
        return total;
    }

    private int calculateFuel(int mass)  {
        int requirements = (int) Math.floor(mass / 3.0) - 2;
        return Math.max(0, requirements);
    }
}
