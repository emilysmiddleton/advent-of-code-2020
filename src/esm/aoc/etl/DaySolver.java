package esm.aoc.etl;

import esm.aoc.etl.extract.Extractor;
import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.solve.Solver;
import esm.aoc.etl.transform.Transformer;

public class DaySolver<M, S> {

    private final Extractor extractor;
    private final Transformer<M> transformer;
    private final Solver<M, S> solver;

    public DaySolver(Extractor extractor, Transformer<M> transformer, Solver<M, S> solver) {
        this.extractor = extractor;
        this.transformer = transformer;
        this.solver = solver;
    }

    public S solve() {
        PuzzleInput input = extractor.readLines();
        M model = transformer.buildModel(input);
        return solver.solve(model);
    }
}
