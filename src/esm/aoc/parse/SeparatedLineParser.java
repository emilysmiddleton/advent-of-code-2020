package esm.aoc.parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * For files where the input is a single comma-separated line.
 */
public class SeparatedLineParser implements LinesParser<List<String>> {

    public static final SeparatedLineParser COMMA_SEPARATED = new SeparatedLineParser(",");

    private final String separator;

    public SeparatedLineParser(String separator) {
        this.separator = separator;
    }

    @Override
    public List<String> parse(List<String> lines) {
        String firstLine = lines.get(0);
        return Arrays.asList(firstLine.split(separator));
    }

}
