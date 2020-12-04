package esm.aoc.days.day04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passport {

    private static final Pattern HEIGHT_CM = Pattern.compile("(\\d+)cm");
    private static final Pattern HEIGHT_INCH = Pattern.compile("(\\d+)in");
    private static final Pattern HAIR_COLOUR = Pattern.compile("#([a-f,0-9]{6})");
    private static final Pattern EYE_COLOUR = Pattern.compile("amb|blu|brn|gry|grn|hzl|oth");
    private static final Pattern PASSPORT_ID = Pattern.compile("[0-9]{9}");

    private String byr;
    private String iyr;
    private String eyr;
    private String hgt;
    private String hcl;
    private String ecl;
    private String pid;
    private String cid;

    public void addKey(String key, String value) {
        switch (key) {
            case "byr": this.byr = value; return;
            case "iyr": this.iyr = value; return;
            case "eyr": this.eyr = value; return;
            case "hgt": this.hgt = value; return;
            case "hcl": this.hcl = value; return;
            case "ecl": this.ecl = value; return;
            case "pid": this.pid = value; return;
            case "cid": this.cid = value; return;
            default: throw new IllegalArgumentException("Unknown key " + key);
        }
    }

    public boolean hasPresentFields() {
        return byr != null && iyr != null && eyr != null && hgt != null && hcl != null && ecl != null && pid != null;
    }

    public boolean hasValidFields() {
        return hasPresentFields() &&
                // byr (Birth Year) - four digits; at least 1920 and at most 2002
                getByr() >= 1920 && getByr() <= 2002 &&
                // iyr (Issue Year) - four digits; at least 2010 and at most 2020.
                getIyr() >= 2010 && getIyr() <= 2020 &&
                // eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
                getEyr() >= 2020 && getEyr() <= 2030 &&
                // hgt (Height) - a number followed by either cm or in:
                //If cm, the number must be at least 150 and at most 193.
                ((getHgtCm() >= 150 && getHgtCm() <= 193) ||
                //If in, the number must be at least 59 and at most 76
                (getHgtIn() >= 59 && getHgtIn() <= 76)) &&
                // hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
                HAIR_COLOUR.matcher(hcl).matches() &&
                // ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
                EYE_COLOUR.matcher(ecl).matches() &&
                // pid (Passport ID) - a nine-digit number, including leading zeroes.
                PASSPORT_ID.matcher(pid).matches();
    }

    public int getByr() {
        return Integer.parseInt(byr);
    }

    public int getIyr() {
        return Integer.parseInt(iyr);
    }

    public int getEyr() {
        return Integer.parseInt(eyr);
    }

    public int getHgtCm() {
       Matcher matcher = HEIGHT_CM.matcher(hgt);
       return matcher.matches() ? Integer.parseInt(matcher.group(1)) : -1;
    }

    public int getHgtIn() {
        Matcher matcher = HEIGHT_INCH.matcher(hgt);
        return matcher.matches() ? Integer.parseInt(matcher.group(1)) : -1;
    }

}
