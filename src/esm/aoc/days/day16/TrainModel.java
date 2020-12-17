package esm.aoc.days.day16;

import java.util.ArrayList;
import java.util.List;

public class TrainModel {

    final List<FieldRestriction> fields = new ArrayList<>();
    Ticket myTicket;
    final List<Ticket> otherTickets = new ArrayList<>();

    public void addField(FieldRestriction field) {
        fields.add(field);
    }
    public List<FieldRestriction> getFields() {
        return fields;
    }

    public Ticket getMyTicket() {
        return myTicket;
    }

    public void setMyTicket(Ticket myTicket) {
        this.myTicket = myTicket;
    }

    public void addTicket(Ticket ticket) {
        otherTickets.add(ticket);
    }

    public List<Ticket> getOtherTickets() {
        return otherTickets;
    }
}
