package esm.aoc.days.day16;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.transform.IntegersTransformer;
import esm.aoc.etl.transform.StringSeparatedTransformer;
import esm.aoc.etl.transform.Transformer;
import esm.aoc.models.partition.Partition;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements Transformer<TrainModel> {

    private static final Pattern FIELD_PATTERN = Pattern.compile("(.*): (\\d+)-(\\d+) or (\\d+)-(\\d+)");
    @Override
    public TrainModel buildModel(PuzzleInput input) {
        TrainModel model = new TrainModel();
        for (String line : input.getLines()) {
            Matcher matcher = FIELD_PATTERN.matcher(line);
            if (matcher.matches()) {
                Partition[] partitions = {
                        new Partition(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3))),
                        new Partition(Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)))
                };
                model.addField(new FieldRestriction(matcher.group(1), partitions));
            } else {
                if (!line.isEmpty() && !"your ticket:".equals(line) && !"nearby tickets:".equals(line)) {
                    model.addTicket(createTicket(line));
                }
            }
        }
        return model;
    }

    private Ticket createTicket(String line) {
        List<Integer> values = IntegersTransformer.TO_INTEGERS.parseInts(
                StringSeparatedTransformer.COMMA_SEPARATED.parseLine(line)
        );
        return new Ticket(values);
    }
}
