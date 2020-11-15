package esm.aoc.etl.solve;

/**
 * The solution to the problem is a single value, usually numeric but sometimes a string.
 */
public interface Solver<M, S> {

    S solve(M model);

}
