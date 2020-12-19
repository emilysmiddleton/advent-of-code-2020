package esm.aoc.models.grid;

import java.util.*;
import java.util.stream.Collectors;

public class CoordinateND {

    List<Integer> indexes;

    public CoordinateND(List<Integer> indexes) {
        this.indexes = indexes;
    }

    public int getIndex(int axis) {
        return indexes.get(axis);
    }

    public List<CoordinateND> getAdjacent() {
        Set<List<Integer>> adjacent = new LinkedHashSet<>();
        adjacent.add(new ArrayList<>());
        for (int axis = 0; axis < indexes.size(); axis++) {
            adjacent = expand(adjacent, axis);
        }
        return adjacent.stream()
                .map(CoordinateND::new)
                .filter(c -> !c.equals(this))
                .collect(Collectors.toList());
    }

    private Set<List<Integer>> expand(Set<List<Integer>> current, int axis) {
        int[] adjacent = { -1, 0, 1 };
        Set<List<Integer>> next = new LinkedHashSet<>();
        for (List<Integer> coords : current) {
            for (int i : adjacent) {
                List<Integer> copy = new ArrayList<>(coords);
                copy.add(indexes.get(axis) + i);
                next.add(copy);
            }
        }
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateND that = (CoordinateND) o;
        return Objects.equals(indexes, that.indexes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indexes);
    }
}
