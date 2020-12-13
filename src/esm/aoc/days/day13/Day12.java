package esm.aoc.days.day13;

public class Day12 {

    public static void main(String[] args) {
        State s1 = new State(0, 41);
        State s2 = new State(-35, 37);
        State s3 = new State(-41, 379);
        State s4 = new State(-49, 23);
        State s5 = new State(-54, 13);
        State s6 = new State(-58, 17);
        State s7 = new State(-70, 29);
        State s8 = new State(-72, 557);
        State s9 = new State(-91, 19);
        State next = s1.combine(s2);
        System.out.println(next);
        next = next.combine(s3);
        System.out.println(next);
        next = next.combine(s4);
        System.out.println(next);
        next = next.combine(s5);
        System.out.println(next);
        next = next.combine(s6);
        System.out.println(next);
        next = next.combine(s7);
        System.out.println(next);
        next = next.combine(s8);
        System.out.println(next);
        next = next.combine(s9);
        System.out.println(next);
    }

    private static class State {
        private final long offset;
        private final long cycle;

        public State(long offset, long cycle) {
            this.offset = offset;
            this.cycle = cycle;
        }

        public State combine(State next) {
            boolean found = false;
            long i = offset;
            while (!found) {
                i += cycle;
                found = (i - next.offset) % next.cycle == 0;
            }
            return new State(i, cycle * next.cycle);
        }

        @Override
        public String toString() {
            return "State{" +
                    "offset=" + offset +
                    ", cycle=" + cycle +
                    '}';
        }
    }
}
