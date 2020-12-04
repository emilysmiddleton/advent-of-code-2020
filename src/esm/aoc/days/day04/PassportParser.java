package esm.aoc.days.day04;

import esm.aoc.etl.extract.PuzzleInput;
import esm.aoc.etl.transform.Transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PassportParser implements Transformer<List<Passport>> {

    @Override
    public List<Passport> buildModel(PuzzleInput input) {
        List<Passport> passports = new ArrayList<>();
        Passport current = new Passport();
        for (String line : input.getLines()) {
            if (line.length() == 0) {
                passports.add(current);
                current = new Passport();
            } else {
                String[] keys = line.split(" ");
                Passport passport = current;
                Arrays.stream(keys)
                        .map(key -> key.split(":"))
                        .forEach(split -> passport.addKey(split[0], split[1]));
            }
        }
        return passports;
    }

}
