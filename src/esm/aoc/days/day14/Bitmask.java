package esm.aoc.days.day14;

import java.math.BigInteger;

public class Bitmask {

    private Long and;
    private Long or;

    public Bitmask(String mask) {
        or = Long.parseLong(mask.replaceAll("X", "0"), 2);
        and = Long.parseLong(mask.replaceAll("X", "1"), 2);
    }

    public Long mask(Long input) {
        return (input | or) & and;
    }

}
