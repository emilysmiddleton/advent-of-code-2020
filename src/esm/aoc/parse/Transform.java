package esm.aoc.parse;

public interface Transform<T> {

    public static final Transform<Integer> TO_INT = new Transform<Integer>() {
        @Override
        public Integer transform(String input) {
            return Integer.parseInt(input);
        }
    };

    T transform(String input);

}

