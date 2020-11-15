package esm.aoc.etl.extract;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PuzzleInputExtractor implements Extractor {

    private final int day;

    public PuzzleInputExtractor(int day) {
        this.day = day;
    }

    public PuzzleInput readLines() {
        String filename = String.format("inputs/day%d.txt", this.day);
        List<String> lines = new ArrayList<>();
        try {
            File inputFile = new File(filename);
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Failed to read " + filename);
        }
        return new PuzzleInput(lines);
    }
}
