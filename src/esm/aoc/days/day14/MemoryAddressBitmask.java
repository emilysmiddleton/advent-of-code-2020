package esm.aoc.days.day14;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryAddressBitmask {

    private String[] mask;


    public static void main(String[] args) {
        MemoryAddressBitmask bitmask = new MemoryAddressBitmask("000000000000000000000000000000X1001X");
        System.out.println(bitmask.getAddresses(42));
    }
    public MemoryAddressBitmask(String mask) {
        this.mask = mask.split("");
    }

    public List<Long> getAddresses(int index) {
        String binary = getBinary(index);
        String masked = mask(binary);
        List<String> expanded = expand(masked);
        return expanded.stream().map(s -> Long.parseLong(s, 2)).collect(Collectors.toList());
    }

    public String mask(String input) {
        StringBuilder builder = new StringBuilder();
        String[] array = input.split("");
        for (int i = 0; i < mask.length; i++) {
            String m = mask[i];
            String a = array[i];
            if ("X".equals(m)) {
                builder.append("X");
            } else {
                if ("1".equals(m) || "1".equals(a)) {
                    builder.append("1");
                } else {
                    builder.append("0");
                }
            }
        }
        return builder.toString();
    }

    public List<String> expand(String input) {
        List<String> expanded = new ArrayList<>();
        if (input.contains("X")) {
            expanded.addAll(expand(input.replaceFirst("X", "0")));
            expanded.addAll(expand(input.replaceFirst("X", "1")));
        } else {
            expanded.add(input);
        }
        return expanded;
    }

    public String getBinary(int input) {
        String binary = Integer.toBinaryString(input);
        return "0".repeat(36 - binary.length()) + binary;
    }


}
