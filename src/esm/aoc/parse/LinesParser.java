package esm.aoc.parse;

import java.util.List;

interface LinesParser<T> {

    T parse(List<String> lines);

}
