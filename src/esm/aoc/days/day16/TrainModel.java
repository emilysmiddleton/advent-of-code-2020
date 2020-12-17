package esm.aoc.days.day16;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainModel {

    final List<FieldRestriction> fields = new ArrayList<>();
    final List<Ticket> tickets = new ArrayList<>();

    public void addField(FieldRestriction field) {
        fields.add(field);
    }
    public List<FieldRestriction> getFields() {
        return fields;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public boolean isValid(Ticket ticket) {
        return getInvalidFields(ticket).isEmpty();
    }

    public List<Integer> getInvalidFields(Ticket ticket) {
        return ticket.getFields().stream().filter(value -> !isValidField(value)).collect(Collectors.toList());
    }

    private boolean isValidField(int value) {
        return fields.stream().map(field -> field.isValid(value)).reduce(false, (a, b) -> a || b);
    }

    public List<Integer> getValuesAtPosition(int index) {
        return tickets.stream().filter(this::isValid).map(t -> t.getFields().get(index)).collect(Collectors.toList());
    }
}
