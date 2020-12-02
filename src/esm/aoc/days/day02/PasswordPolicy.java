package esm.aoc.days.day02;

public class PasswordPolicy {
    private final int first;
    private final int second;
    private final String character;
    private final String password;

    public PasswordPolicy(int first, int second, String character, String password) {
        this.first = first;
        this.second = second;
        this.character = character;
        this.password = password;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public String getCharacter() {
        return character;
    }

    public String getPassword() {
        return password;
    }
}
