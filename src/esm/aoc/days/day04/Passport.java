package esm.aoc.days.day04;

import java.util.ConcurrentModificationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passport {

    private static final Pattern HEIGHT = Pattern.compile("(\\d+)(cm|in)");
    private static final Pattern HAIR_COLOUR = Pattern.compile("#[a-f,0-9]{6}");
    private static final Pattern EYE_COLOUR = Pattern.compile("amb|blu|brn|gry|grn|hzl|oth");
    private static final Pattern PASSPORT_ID = Pattern.compile("[0-9]{9}");

    private String byr;
    private String iyr;
    private String eyr;
    private String hgt;
    private String hcl;
    private String ecl;
    private String pid;

    public void addKey(String key, String value) {
        switch (key) {
            case "byr": this.byr = value; return;
            case "iyr": this.iyr = value; return;
            case "eyr": this.eyr = value; return;
            case "hgt": this.hgt = value; return;
            case "hcl": this.hcl = value; return;
            case "ecl": this.ecl = value; return;
            case "pid": this.pid = value; return;
            case "cid": return;
            default: throw new IllegalArgumentException("Unknown key " + key);
        }
    }

    public boolean hasPresentFields() {
        return byr != null && iyr != null && eyr != null && hgt != null && hcl != null && ecl != null && pid != null;
    }

    public boolean hasValidFields() {
        return hasPresentFields() &&
                between(Integer.parseInt(byr), 1920, 2002) && // four digits; at least 1920 and at most 2002
                between(Integer.parseInt(iyr), 2010, 2020) && // four digits; at least 2010 and at most 2020.
                between(Integer.parseInt(eyr), 2020, 2030) && // four digits; at least 2020 and at most 2030.
                matches(hcl, HAIR_COLOUR) && // a # followed by exactly six characters 0-9 or a-f.
                matches(ecl, EYE_COLOUR)  && // exactly one of: amb blu brn gry grn hzl oth.
                matches(pid, PASSPORT_ID) && // a nine-digit number, including leading zeroes.
                matches(hgt, HEIGHT) &&      // a number followed by either cm or in
                                             // If cm, the number must be at least 150 and at most 193.
                ("cm".equals(getHgtType()) && between(getHgt(), 150, 193) ||
                                             // If in, the number must be at least 59 and at most 76.
                 "in".equals(getHgtType()) && between(getHgt(), 59, 76));
    }

    public int getHgt() {
       Matcher matcher = HEIGHT.matcher(hgt);
       return matcher.matches() ? Integer.parseInt(matcher.group(1)) : -1;
    }

    public String getHgtType() {
        Matcher matcher = HEIGHT.matcher(hgt);
        return matcher.matches() ? matcher.group(2) : "";
    }

    private boolean between(int value, int min, int max) {
        return value >= min && value <= max;
    }

    private boolean matches(String value, Pattern pattern) {
        return pattern.matcher(value).matches();
    }

}
