package esm.aoc.parse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * For files where the input is a single comma-separated line.
 */
public class SeparatedLineParser implements LinesParser<List<List<String>>> {

    public static final SeparatedLineParser COMMA_SEPARATED = new SeparatedLineParser(",");
    public static final SeparatedLineParser NO_SEPARATOR = new SeparatedLineParser("");

    private final String separator;

    public SeparatedLineParser(String separator) {
        this.separator = separator;
    }

    @Override
    public List<List<String>> parse(List<String> lines) {
        return lines.stream().map(this::parseLine).collect(Collectors.toList());
    }

    private List<String> parseLine(String line) {
        return Arrays.asList(line.split(separator));
    }

}
