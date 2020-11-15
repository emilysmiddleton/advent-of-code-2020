package esm.aoc.parse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {

    private final int day;

    public InputReader(int day) {
        this.day = day;
    }

    public List<String> read() {
        String filename = String.format("inputs/day%d.txt", this.day);
        List<String> output = new ArrayList<>();
        try {
            File inputFile = new File(filename);
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                output.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Failed to read " + filename);
        }
        return output;
    }
}
