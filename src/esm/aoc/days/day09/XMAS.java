package esm.aoc.days.day09;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class XMAS {

    private final List<Long> numbers;

    public XMAS(List<Long> numbers) {
        this.numbers = numbers;
    }

    public long getFirstInvalid() {
        for (int i = 25; i < numbers.size(); i++) {
            if (!isValid(i)) {
                return numbers.get(i);
            }
        }
        return -1;
    }

    public List<Long> getContiguousSum() {
        long target = getFirstInvalid();
        for (int i = 0; i < numbers.indexOf(target); i++) {
            List<Long> values = findSum(i, target);
            if (values != null) {
                return values;
            }
        }
        return null;
    }

    public List<Long> findSum(int startIndex, long target) {
        long sum = 0;
        int i = startIndex;
        List<Long> values = new ArrayList<>();
        while (sum < target) {
            sum += numbers.get(i);
            values.add(numbers.get(i));
            i++;
        }
        return sum == target ? values : null;
    }

    private boolean isValid(int position) {
        Set<Long> sums = sums(position - 25, position);
        return sums.contains(numbers.get(position));
    }

    private Set<Long> sums(int start, int end) {
        Set<Long> sums = new LinkedHashSet<>();
        for (int i = start; i < end; i++) {
            for (int j = start; j < end; j++) {
                if (i != j) {
                    sums.add(numbers.get(i) + numbers.get(j));
                }
            }
        }
        return sums;
    }

}
